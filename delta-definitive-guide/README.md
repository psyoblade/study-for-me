# Prologue.
> 

## 5장

* 델타의 경우 가장 먼저 원하는 형태의 테이블 프로퍼티 설계가 된, 테이블 생성이 시작이다
* bin-packing? small-files to big-files

### OPTIMIZE 설정
* (Spark only) spark.databricks.delta.optimize.minFileSize (long) 
  * 지정된 임계치 파일의 크기(바이트 수)보다 작은 파일을 하나로 묶어주는 설정
* (Spark only) spark.databricks.delta.optimize.maxFileSize (long)
  * 지정된 임계치 파일의 크기(바이트 수)보다는 큰 파일은 생성되지 않도록 제약하는 설정
* (Spark only) spark.databricks.delta.optimize.repartition.enabled (bool=true)
  * coalesce(1) 대신 repartition(1) 사용하도록 설정
* (delta-rs) The table property delta.targetFileSize (string)
  * 250mb 설정의 경우 delta-rs client 가 사용하는 메모리 설정이 가능하지만 OSS delta 릴리즈는 지원하지 않는다

### Z-Order 최적화
* delta.dataSkippingNumIndexedCols (int=32) 
  * 기본 32개 컬럼의 메타정보를 지정한 숫자로 줄여주는 것
* delta.checkpoint.writeStatsAsStruct (bool=false)
  * 파케이 포맷형식으로 컬럼 통계정보를 저장하는 것을 허용할 지 여부
  * 모든 벤더가 델타 레이크 솔루션을 지원하는 것은 아니므로 기본 값을 false

### 테이블 튜닝 관리

#### 파티셔닝
* 1TB 가 넘지 않는다면 파티셔닝 하지마라
* 카디낼러티가 낮은 파티션 컬럼을 지정하라 (ex_ date)



## 7장
### 델타 스트리밍 옵션
* maxFilesPerTrigger
  * This sets the limit for how many new files will be considered in every micro‐ batch.
  * The default value is 1000.
* maxBytesPerTrigger
  * This sets an approximate limit for how much data gets processed in each microbatch. 
  * This option sets a soft max, meaning that a microbatch processes approximately this amount of data but can process more when the smallest input unit is larger than this limit. 
  * In other words, this size setting operates more like a threshold value that needs to be exceeded, whether with one file or with many files; however many files it takes to get past this threshold, it will use that many files—kind of like a dynamic setting for the number of files in each microbatch that uses an approximate size. 

## 10장
### 성능 목적
#### 읽기 성능 최대
* 포인트 쿼리
* 레인지 쿼리
* 집계 쿼리

#### 쓰기 성능 최대


### 성능 고려사항
#### 파티셔닝

#### 테이블 도구
* OPTIMIZE
* Z-Ordering
  * Auto Compaction
    * spark.databricks.delta.autoCompact.maxFileSize (128mb)
    * spark.databricks.delta.autoCompact.minNumFiles (50)
  * Optimized Writes
    * spark.databricks.delta.optimizeWrites.enabled (true)
