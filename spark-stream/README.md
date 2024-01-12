# Spark Structured Streaming
> [Kafka offset committer for Spark structured streaming](https://github.com/HeartSaVioR/spark-sql-kafka-offset-committer/tree/develop-spark3.0) 코드를 이해하기 위해
> [Deep Dive Spark Structured Streaming](https://dataninjago.com/category/deep-dive-spark-structured-streaming/) 문서를 순차적으로 읽고 정리


## [Execution Flow - 1 of 7](https://dataninjago.com/2022/06/02/spark-structured-streaming-deep-dive-1-execution-flow/)
> 모든 내용을 정리하기 보다, 궁금한 점들 위주로 질문 답변을 먼저 정리합니다

### Q1. `StreamExecution` 과 `StreamingQueryWrapper` 의 차이점
* [`KafkaOffsetCommitterListener`](https://github.com/HeartSaVioR/spark-sql-kafka-offset-committer/blob/develop-spark3.0/src/main/scala/net/heartsavior/spark/KafkaOffsetCommitterListener.scala#L40) 코드에서 왜 구분하여 처리하는가?
  - [`StreamExecution`](https://books.japila.pl/spark-structured-streaming-internals/StreamExecution/)
    - 현재 사용중인 `SparkSession`의 `StreamingQueryManager`에 의해 생성 및 기동
    - **스트리밍 쿼리를 수행의 생명주기를 관장하는 인스턴스**이며, `MicroBatchExecution` 혹은 `ContinuousExecution` 이 실제 구현체
    - `SparkSession`의 'activeQueries' 해시맵을 통해 관리되며 `SparkSession.active.streams.get` 통해서 접근이 가능하다
  - [`StreamingQueryWrapper`](https://books.japila.pl/spark-structured-streaming-internals/StreamingQueryWrapper/)
    - 스트림쿼리래퍼는 완전히 동일한 API를 가진 스트림익스큐션의 직렬화 인터페이스이며, 스트림쿼리매니저가 쿼리생성 시에 래퍼가 생성됩니다
  - [`StreamExecution`](https://books.japila.pl/spark-structured-streaming-internals/StreamExecution/)
* [onQueryProgress]()
```scala
class KafkaOffsetCommitterListener extends StreamingQueryListener with Logging {
  
  override def onQueryProgress(event: StreamingQueryListener.QueryProgressEvent): Unit = {
    
    // 현재 실행 중인 스파크 세션의 실행 캐시로부터 마지막 스트림 실행 객체(StreamExecution)를 획득
    // query: StreamingQuery
    //  Manages the execution of a streaming Spark SQL query that is occurring in a separate thread. 
    //  Unlike a standard query, a streaming query executes repeatedly each time new data arrives at any Source present in the query plan. 
    //  Whenever new data arrives, a QueryExecution is created and the results are committed transactionally to the given Sink.
    val query = SparkSession.active.streams.get(event.progress.id)
    if (query != null) {
      val exec = query match {
        case query: StreamingQueryWrapper => Option(query.streamingQuery.lastExecution)
        case query: StreamExecution => Option(query.lastExecution)
        case _ =>
          logWarning(s"Unexpected type of streaming query: ${query.getClass}")
          None
      }

      // 실행 관리자로부터 원천소스 정보에 해당하는 카프카 파라메터 핸들러를 획득
      // ex: IncrementalExecution
      //  A variant of QueryExecution that allows the execution of the given LogicalPlan plan incrementally. 
      //  Possibly preserving state in between each execution.
      exec.foreach { ex =>
        val inspector = new KafkaSourceInspector(ex.executedPlan)
        val idxToKafkaParams = inspector.populateKafkaParams
        
        // 사용 중인 모든 소스로부터
        idxToKafkaParams.foreach { case (idx, params) =>
          params.get(CONFIG_KEY_GROUP_ID) match {
            case Some(groupId) =>
              
              // 해당 소스의 토픽에 대한 오프셋값을 얻어옵니다 
              val sourceProgress = event.progress.sources(idx)
              val tpToOffsets = inspector.partitionOffsets(sourceProgress.endOffset)

              val newParams = new scala.collection.mutable.HashMap[String, Object]
              newParams ++= params
              newParams += "group.id" -> groupId

              // 카프카 컨슈머 클라이언트를 생성하고
              val kafkaConsumer = new KafkaConsumer[String, String](newParams.asJava)
              try {
                
                // { 토픽 : 마지막 실행 오프셋값 } 쌍을 
                val offsetsToCommit = tpToOffsets.map { case (tp, offset) =>
                  (tp -> new OffsetAndMetadata(offset))
                }
                
                // 카프카 컨슈머에 10초 타임아웃으로 저장합니다
                kafkaConsumer.commitSync(offsetsToCommit.asJava, Duration.ofSeconds(10))
              } finally {
                kafkaConsumer.close()
              }

            case None =>
          }
        }
      }
    } else {
      logWarning(s"Cannot find query ${event.progress.id} from active spark session!")
    }
  }

}
```

### Q2. 그래서 어떻게 동작하는 건데?
* StreamDataWriter 를 통해서 StreamingQuery 가 생성되며, 매 마이크로 배치마다 StreamExecution 이 생성된다
* 해당 쿼리를 StreamingQueryWrapper 를 통해서 스크림 쿼리 라이프 싸이클 관리자인 StreamExecution 에 접근할 수 있다
```scala
import org.apache.spark.sql.streaming.Trigger
import scala.concurrent.duration._
val q = spark.
  readStream.
  format("rate").
  load.
  writeStream.
  format("console").
  trigger(Trigger.ProcessingTime(10.minutes)).
  start
scala> :type q
org.apache.spark.sql.streaming.StreamingQuery

// Pull out StreamExecution off StreamingQueryWrapper
import org.apache.spark.sql.execution.streaming.{StreamExecution, StreamingQueryWrapper}
val se = q.asInstanceOf[StreamingQueryWrapper].streamingQuery
scala> :type se
org.apache.spark.sql.execution.streaming.StreamExecution
```

### Q3. 스트리밍 앱에서 속성 값의 의미
* query.id : 스트리밍 애플리케이션 최초 실행 시에 생성되는 유일한 id 값
  * get the unique identifier of the running query that persists across restarts from checkpoint data
* query.runId : 매 쿼리 실행 시마다 변경되는 id 값
  * get the unique id of this run of the query, which will be generated at every start/restart