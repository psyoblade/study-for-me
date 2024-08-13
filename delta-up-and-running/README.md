# Delta Up and Running
> 2024.6 부터, [Delta Lake: Up & Running](https://www.databricks.com/resources/ebook/delta-lake-running-oreilly) 읽기 시작

## 1. 데이터 아키텍처의 진화

### 개요
> 데이터 엔지니어는 대규모 데이터, 기계학습, 데이터과학 및 AI 솔루션을 구축하고, 이를 위한 데이터를 수집, 정리, 정규화 및 통합하고
> 궁극적으로 손쉽게 이용할 수 있는 데이터 모델링을 제공하고 이러한 데이터를 다운스트림 애플리케이션에서 활용가능한 서비스를 제공해야 합니다

#### 데이터 처리 요구사항
* 수집해야 하는 데이터의 양이 수평적으로 증가함에 따라 저장 및 처리를 위한 리소스 확장이 필요하며
* 대용량 데이터에 대해 지속적으로 레코드 삽입, 업데이트 및 병합 등의 트랜잭션이 필요할 수 있습니다

#### 패러다임의 진화 
* 데이터웨어하우스 : 트랜잭션과 안정적인 스키마 및 모델링을 제공
* 데이터레이크 : 수평적인 확장과 대용량 데이터 저장 및 처리 기능을 제공
* 레이크하우스 : `Delta Lake` 와 같은 분산 저장소 저장 프레임워크를 활용하여 확장성, 성능 그리고 트랜잭션 안정성을 모두 제공

#### 관계형 데이터베이스의 역사
> SQL 언어는 1980년대와 1990년대 엔터프라이즈 애플리케이션의 표준 기술이었고, 트랜잭션 지원으로 가장 강력한 데이터 도구로 자리매김 했습니다
> 이 트랜잭션은 데이터를 처리하는 데에 있어 ACID (원자성, 일관성, 격리성 및 내구성)한 속성을 보장하기 때문에 안전한 데이터 처리가 가능합니다

* 독립된 엔진을 통해 저장해야 해서, 데이터 사일로가 증가하게 되었고, 전사적인 데이터 관리 및 분석을 위해 데이터웨어하우스가 등장합니다
* 데이터웨어하우스는 장기간에 걸친 데이터 분석 및 다양한 차원(고객, 제품, 사업체 등)을 통해 교차 분석이 가능하게 합니다
![데이터웨어하우스 아키텍처](images/datawarehouse-architecture.png)

* 데이터웨어하우스는 다양한 소스로부터 데이터입수를 하기 위해 표준화된 형식으로 변환 후 다운스트림 프로세스가 접근가능한도록 제공해야 합니다
* 데이터 입수, 변환 및 적재를 ETL 이라하며, 데이터가 커지고 사용자가 늘어남에 따라 통합된 뷰를 제공하기 위해 모델링(스키마)를 도입합니다
* 뿐만 아니라 데이터 거버넌스 표준을 제공하기 위해 다양한 품질검사와, 검증을 위한 후처리 작업이 필요합니다
* 데이터웨어하우스는 전통적인 데이터베이스 기반의 서비스이므로 모놀리식 아키텍처 기반으로 구성 및 서비스하는 경우가 가장 많습니다
* 이렇게 구성된 데이터는 내/외부 시스템, 보고서, 온라인 분석 (OLAP) 및 데이터 마이닝 등에 활용됩니다
![판매 차원 모델](images/sales-star-schema.png)

#### 데이터웨어하우스의 특징
* 공통된 스키마를 통해 정제되고 정규화된 고품질 데이터를 제공합니다
* 시간 차원을 기본으로 저장 및 처리하므로 과거로부터 현재까지의 기간 추세분석을 통한 통찰력을 제공합니다
* ACID 한 트랜잭션을 제공하며, 스타 스키마 모델링 기반의 팩트 및 요약 테이블을 통해 다양한 분석이 가능합니다
* 기본적으로 "어떤 사건이 발생했는가?"라는 질문을 해결하는 비즈니스 인텔리전스 서비스라고 볼 수 있습니다
* 다만, 대용량 데이터의 4V(Volume, Velocity, Variety, Veracity 등) 문제를 해소하기는 어렵습니다

#### 데이터레이크 소개
> 초기 데이터레이크는 아파치 하둡 프레임워크를 기반으로 온프레미스 클러스터로 구축되었습니다
> 하둡 서비스 상에 다양한 오픈소스 에코시스템을 활용하여 빅데이터 처리를 위한 환경을 구성할 수 있습니다
![데이터 레이크](images/data-lake.png)

#### 데이터레이크의 특징
* 하둡은 분산 저장소(스토리지), 컴퓨팅 엔진을 제공하며, 오픈소스 에코시스템을 통해 다양한 포맷 및 메타데이터를 활용할 수 있습니다
* 저장 및 처리 시스템의 확장 및 배포가 안정적으로 가능하며, 비정형 데이터를 포함한 모든 데이터 유형을 지원합니다
* 데이터를 수집하는 것과 이러한 데이터를 비즈니스 가치를 제공하는 형식으로 변환 및 유지하는 데에는 많은 비용과 노하우가 필요하게 됩니다
* 조직의 데이터 팀은 데이터를 데이터 웨어하우스와 같은 것으로 변환하고 서빙하는 과정에서 가치 창출 시간이 지연될 수 있음을 알아야 합니다

> 데이터 레이크의 가장 핵심 가치는 **데이터 파이프라인의 자동화와 안정성** 그리고 **가치 창출에 필요한 데이터를 딜리버리 하는 시간을 단축**하는 데에 있다

#### 데이터 레이크 하우스
> Armbrust, Ghodsi, Xin, Zaharia 는 2021년에 데이터 레이크하우스 개념을 처음으로 도입했고, 이는 "ACID 트랜잭션, 데이터 버전관리, 감사
> 색인, 캐싱 및 쿼리 최적화" 등의 기술을 통해 데이터레이크 환경에서 데이터웨어하우스 기능을 제공하는 데이터 관리시스템으로 정의합니다
> 즉, 데이터레이크의 확장성, 처리 성능을 보장하면서 데이터웨어하우스의 트랜잭션, 스키마 모델링의 안정성을 보장하는 시스템입니다

#### 데이터 레이크하우스의 특징
> 데이터레이크와 같이 별도의 데이터 사본을 보관하고 저장할 필요가 없기 때문에, 데이터 이동이 줄어들고 ETL 단순화를 통해 품질 이슈를 줄입니다
> 대용량 데이터 저장과 정제된 차원 모델을 통해 개발주기 감소와 가치 창출에 이르는 시간을 단축할 수 있습니다
![데이터 아키텍처의 진화](images/evolution-of-data-architecture.png)

#### 델타 레이크
> 메타데이터, 캐싱 및 인덱싱을 스토리지 수준에서 제공하는 개방형 데이터 포맷(Parquet)을 지향하는 데이터 저장 프레임워크입니다
> 이는 ACID 트랜잭션, 감사, 히스토리 및 테이블 관리기능을 제공하는 추상화 수준을 API 및 SQL 수준에서 지원합니다

* ACID 트랜잭션, DML 지원, 감사, 배치/스트리밍 처리 통합, 스키마 에볼루션, 메타데이터 지원 등의 주요 기능이 제공됩니다
![델타레이크 계층형 아키텍처](images/delta-lake-architecture.png)

#### 메달리온 아키텍처
> 브론즈, 실버 및 골드 레이어로 데이터의 활용 및 특성에 따라 구분하는 데이터 관리 아키텍처를 말합니다
![메달리온 아키텍처](images/medallion-architecture.png)

* 원본 데이터를 그대로 보관 및 저장하는 `브론즈`, 정규화, 정재 및 병합된 데이터가 보관되는 `실버` 그리고 안전하게 사용할 수 있는 팩트, 요약
* 테이블 등이 저장되는 `골드` 레이어로 구분됩니다

#### 결론
> 데이터의 양, 속도, 다양성 등을 고려할 때 데이터웨어하우스와 데이터레이크의 한계와 과제는 새로운 데이터 패러다임을 주도했습니다
> 델타 레이크와 같은 개방형 테이블 형식으로의 발전을 통해 제안된 데이터 레이크하우스 아키텍처는 이전 버전의 데이터 플랫폼의 통합이 가능했고
> 이를 통해 확장성, 안정성 및 다양한 기능을 제공하는 현대적인 데이터 아키텍처를 지원할 수 있었습니다



## 2. 델타 레이크 시작하기
> '트랜잭션 보장', 'DML 지원', '감사', '통합 스트리밍 및 배치 모델', '스키마 강제', '확장 가능한 메타데이터 모델' 지원에 대해 소개합니다

### 2-1. 실행 환경 구축
* [delta-for-dummies](https://github.com/psyoblade/delta-for-dummies) 프로젝트를 통해서 실행 환경 구축

### 2-2. 데이터 저장 포맷
> 델타 레이크는 기본적으로 Parquet 포맷을 활용하기에 기존 테이블과 호환성을 보장하며, 추가적인 메타데이터를 활용하여 INSERT, UPDATE,
> DELETE 와 같은 RDBMS 에서 지원하는 DML 작업을 수행할 수 있습니다. 테이블 저장 경로에 생성되는 `_delta_log` 아래에 트랜잭션 로그가
> 생성 및 관리되는데, 이러한 트랜잭션 로그를 통해서 어떻게 ACID 한 트랜잭션을 지원하는 지를 이해합니다

#### Parquet 파일
* 로우 기반 파일포맷과, 열 기반 파일 포맷의 차이점
![logical-table-representation](images/logical-table-representation.png)

* 열 기반 파일 포맷의 장점
  * 컬럼의 데이터 유형에 따라 유연한 압축 옵션과, 확장 가능한 인코딩 스키마를 지원하여 열 단위 압축에 효율적입니다
  * 행 및 열 그룹에 대한 통계정보(최소값, 최대값 및 빈도 등) 및 데이터 스키마를 가지기 때문에 데이터 읽기에 효과적입니다

![parquet-file-composition](images/parquet-file-composition.png)

* 파케이 파일의 장점
  * 열 단위 데이터 저장
    * 개별 열에 저장된 유형에 맞는 압축 및 인코딩 알고리즘 활용으로 저장 및 읽기 성능을 향상시킵니다
    * 컬럼 프로젝션 시에 `Column Pruning` 기법을 통해 네트워크 및 디스크 I/O 를 줄여 성능을 향상 시킵니다
  * 메타데이터 저장
    * 행 그룹, 데이터 스키마, 및 열에 대한 정보(최대, 최소, 빈도 등)를 저장합니다
    * 열 통계정보를 활용하여 특정 블록을 건너뛰는 `Data Skipping` 과 같은 기법을 활용하여 I/O 성능 향상을 기대할 수 있습니다
  * 유형 별 압축 및 인코딩
    * 컬럼 단위 압축을 통해 압축률을 극대화 하여, 디스크 저장공간을 효과적으로 사용합니다
  * 표준화된 파일 포맷 지원
    * 빅 데이터 처리 플랫폼의 표준 데이터 포맷인 Parquet 포맷을 지원함으로써 뛰어난 상호 운용성을 제공합니다


```python
dataframe.write.format("delta").mode("overwrite").partitionBy("salary").saveAsTable("default.family")
```
* 예제 코드 수행 이후에 `_delta_log` 경로의 트랜잭션 로그 `00000000000000000000.json` 확인
```json
{"protocol":{"minReaderVersion":1,"minWriterVersion":2}}
{"metaData":{"id":"cdb1e796-710d-4813-8174-c1f168fdedb3","format":{"provider":"parquet","options":{}},"schemaString":"{\"type\":\"struct\",\"fields\":[{\"name\":\"id\",\"type\":\"integer\",\"nullable\":true,\"metadata\":{}},{\"name\":\"name\",\"type\":{\"type\":\"struct\",\"fields\":[{\"name\":\"firstName\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"middleName\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"lastName\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}}]},\"nullable\":true,\"metadata\":{}},{\"name\":\"gender\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"birthDate\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ssn\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"salary\",\"type\":\"integer\",\"nullable\":true,\"metadata\":{}}]}","partitionColumns":["salary"],"configuration":{},"createdTime":1723180643772}}
{"add":{"path":"salary=1000/part-00002-6e0802ce-200d-43f3-8e34-924357eb2952.c000.snappy.parquet","partitionValues":{"salary":"1000"},"size":2130,"modificationTime":1723180644150,"dataChange":true,"stats":"{\"numRecords\":1,\"minValues\":{\"id\":1,\"name\":{\"firstName\":\"suhyuk\",\"middleName\":\"psyoblade\",\"lastName\":\"park\"},\"gender\":\"male\",\"birthDate\":\"2000/10/30\",\"ssn\":\"741030\"},\"maxValues\":{\"id\":1,\"name\":{\"firstName\":\"suhyuk\",\"middleName\":\"psyoblade\",\"lastName\":\"park\"},\"gender\":\"male\",\"birthDate\":\"2000/10/30\",\"ssn\":\"741030\"},\"nullCount\":{\"id\":0,\"name\":{\"firstName\":0,\"middleName\":0,\"lastName\":0},\"gender\":0,\"birthDate\":0,\"ssn\":0}}"}}
{"add":{"path":"salary=2000/part-00005-dc386f3a-fe53-4c36-a86b-9a89e0eae250.c000.snappy.parquet","partitionValues":{"salary":"2000"},"size":2109,"modificationTime":1723180644150,"dataChange":true,"stats":"{\"numRecords\":1,\"minValues\":{\"id\":2,\"name\":{\"firstName\":\"youngmi\",\"middleName\":\"kiki\",\"lastName\":\"kim\"},\"gender\":\"female\",\"birthDate\":\"2004/08/08\",\"ssn\":\"770808\"},\"maxValues\":{\"id\":2,\"name\":{\"firstName\":\"youngmi\",\"middleName\":\"kiki\",\"lastName\":\"kim\"},\"gender\":\"female\",\"birthDate\":\"2004/08/08\",\"ssn\":\"770808\"},\"nullCount\":{\"id\":0,\"name\":{\"firstName\":0,\"middleName\":0,\"lastName\":0},\"gender\":0,\"birthDate\":0,\"ssn\":0}}"}}
{"add":{"path":"salary=3000/part-00008-14a500de-d029-4249-94fe-5074c2396313.c000.snappy.parquet","partitionValues":{"salary":"3000"},"size":2096,"modificationTime":1723180644150,"dataChange":true,"stats":"{\"numRecords\":1,\"minValues\":{\"id\":3,\"name\":{\"firstName\":\"sowon\",\"middleName\":\"eva\",\"lastName\":\"park\"},\"gender\":\"female\",\"birthDate\":\"2005/05/20\",\"ssn\":\"040520\"},\"maxValues\":{\"id\":3,\"name\":{\"firstName\":\"sowon\",\"middleName\":\"eva\",\"lastName\":\"park\"},\"gender\":\"female\",\"birthDate\":\"2005/05/20\",\"ssn\":\"040520\"},\"nullCount\":{\"id\":0,\"name\":{\"firstName\":0,\"middleName\":0,\"lastName\":0},\"gender\":0,\"birthDate\":0,\"ssn\":0}}"}}
{"add":{"path":"salary=4000/part-00011-eec39bf9-8b74-402b-a0d1-29ba6f91a471.c000.snappy.parquet","partitionValues":{"salary":"4000"},"size":2089,"modificationTime":1723180644150,"dataChange":true,"stats":"{\"numRecords\":1,\"minValues\":{\"id\":4,\"name\":{\"firstName\":\"sihun\",\"middleName\":\"sean\",\"lastName\":\"park\"},\"gender\":\"male\",\"birthDate\":\"2006/01/14\",\"ssn\":\"080114\"},\"maxValues\":{\"id\":4,\"name\":{\"firstName\":\"sihun\",\"middleName\":\"sean\",\"lastName\":\"park\"},\"gender\":\"male\",\"birthDate\":\"2006/01/14\",\"ssn\":\"080114\"},\"nullCount\":{\"id\":0,\"name\":{\"firstName\":0,\"middleName\":0,\"lastName\":0},\"gender\":0,\"birthDate\":0,\"ssn\":0}}"}}
{"commitInfo":{"timestamp":1723180644301,"operation":"CREATE OR REPLACE TABLE AS SELECT","operationParameters":{"isManaged":"true","description":null,"partitionBy":"[\"salary\"]","properties":"{}"},"isolationLevel":"Serializable","isBlindAppend":false,"operationMetrics":{"numFiles":"4","numOutputRows":"4","numOutputBytes":"8424"},"engineInfo":"Apache-Spark/3.2.1 Delta-Lake/2.0.0","txnId":"33e8e5ec-fa5a-4e47-a051-73e80c16b684"}}
```
* 프로토콜, 테이블 스키마를 정의, 4개의 파티션을 추가 후, 커밋 로그를 저장하는 과정이 하나의 트랜잭션을 구성한다
* `Delta Lake 3.0 (Spark 3.5.0)` 에서는 `Uniform(Universal Format)`을 통해 다양한 포맷(Iceberg, Hudi 등)을 읽을 수 있습니다

```sql
CREATE TABLE T TBLPROPERTIES( 'delta.columnMapping.mode' = 'name', 'delta.universalFormat.enabledFormats' = 'iceberg')
AS SELECT * FROM source_table;
```

> 이와 같이 `_delta_log` 경로에는 데이터에 대해 수행된 모든 단일 작업이 포함된 트랜잭션 로그를 저장합니다.


### 2-3. 트랜잭션 로그
> 델타 레이크 트랜잭션 로그는, 델타 테이블 생성 이후 수행된 모든 트랜잭션의 순차적인 레코드를 저장하는 아카이브 로그입니다. 이는 ACID 한
> 트랜잭션, 확장 가능한 메타데이터 처리, 시간 여행 등 주요기능을 수행하기 위한 델타 레이크의 핵심 정보입니다

#### 트랜잭션 로그의 특징
* 다수의 `Reader` 와 `Writer` 가 특정 버전의 데이터 집합에 대해 동시에 작업
* 효율적인 읽기 쓰기를 위한 `Data Skipping` 을 위한 추가정보 관리 및 제공
* 항상 이용자에게 일관된 보기와 단일 정보 소스(`Truth of Source`) 제공
* 델타 테이블의 모든 변경사항을 저장하는 중앙 저장소 역할

#### 트랜잭션 로그를 읽는 시점
* `Reader`가 델타 테이블 최초로 읽거나, 마지막으로 읽은 이후에 수정된 열린 파일에 대해 새로운 쿼리 수행하는 경우 트랜잭션 로그를 읽습니다
* 즉, 트랜잭션 로그에는 성공한 모든 트랜잭션만 남기 때문에 해당 최신 버전을 읽을 수 있습니다

#### 트랜잭션 로그를 통해 원자성을 구현하는 방법
![actions-of-transaction-log](images/actions-of-transaction-log.png)
* 파일의 추가/삭제, 스키마/파티션 변경 등의 메타데이터 수정 및 커밋 정보가 포함됩니다
  * 모든 트랜잭션 로그 엔트리에는 오퍼레이션이 발생한 시간 등의 커밋 정보가 포함된 `Commit info` 섹션이 추가됩니다 
* 커밋이라는 순서가 단조증가하는 숫자로 구성된 `json` 파일로 기록됩니다
  * 이는 `Git`이 원격지에 코드 및 리소스에 대해 원자적 커밋으로 변경 사항을 추적하는 방법과 유사합니다
  * 이러한 트랜잭션 로그의 개별 커밋을 순차적으로 재생하여 파일의 최종 상태를 얻을 수 있습니다

#### 델타 레이크 데이터 쓰기
![multiple-writes-to-the-same-file](images/multiple-writes-to-the-same-file.png)
* 델타 테이블이 지정된 경로에 데이터를 `part-00000.parquet` 저장하고, 트랜잭션 로그 항목이 `_delta_log/00000.json` 저장

> 각 쓰기 작업마다 항상 데이터 파일이 먼저 기록되고, 해당 작업이 모두 성공한 경우에만 트랜잭션 로그 파일이 저장됩니다.
> 즉, ***트랜잭션 로그가 성공적으로 기록된 경우에만 모든 트랜잭션이 완료된 것으로 간주***합니다

#### 델타 레이크 데이터 읽기
![read-operations](images/read-operations.png)
* 트랜잭션 로그 파일(`00000.json ~ 00002.json`)을 가장 먼저 읽고, 로그 파일을 기반으로 데이터 파일을 읽습니다
* UPDATE, DELETE 등의 연산에 의해 더 이상 참조되지 않는 파일이 있을 수 있으며, 이는 `VACUUM` 명령을 통해 삭제될 수 있습니다

#### 쓰기 실패가 발생한 경우
![write-operation-failure](images/write-operation-failure.png)
* 3번째 작업 수행 시에 데이터는 저장되었으나, 트랜잭션 로그 생성에 실패한 경우, 일관되지 않은 데이터는 읽지 않습니다.
* 이러한 가비지 데이터는 즉각적으로 삭제되지 않으며, `VACUUM` 등의 동작을 통해 안전하게 제거됩니다

#### 데이터 업데이트
![updates-transaction-log](images/updates-transaction-log.png)
* 트랜잭션 로그를 통해 `part-0 ~ part-2` 까지 읽어온 뒤
* `pationtID` 값이 1인 경우만 변경된 `part-3` 파일을 생성하여 추가

![fig.2-8-reading-after-update](images/fig.2-8-reading-after-update.png)
* `00000.json` 파일을 통해 `part-0 ~ part-1` 읽기
* `00001.json` 파일을 통해 `part-2` 읽기
* `00002.json` 파일을 통해 `part-0` 제거 후, `part-3` 읽기 
* 결국 `part-1,2,3` 을 읽게되어 일관된 데이터를 읽을 수 있습니다

![fig.2-9-checkpoint-file](images/fig.2-9-checkpoint-file.png)
* 너무 많은 트랜잭션 로그가 발생하는 경우 스파크 읽기 성능에 악영향을 미칠 수 있으므로 체크포인트 작업을 통해서 최적화 합니다
* 매 10회의 트랜잭션 `00000.json ~ 000009.json` 작업 이후 트랜잭션 생성(11번째)시에 체크포인트 작업을 생성합니다
* `00010.json + 00010.checkpoint.parquet` 와 같이 총 11개의 트랜잭션을 하나로 압축하여 파케이 파일로 저장합니다
* 이와 같이 트랜잭션 로그는 과거의 모든 기록을 유지하고 있기 때문에 초기 메타데이터 로딩시에 오버헤드가 있을 수 있습니다
  * 트랜잭션 로그는 강제로 삭제되지 않으며, 자동삭제 되는데 기본 설정이 30일이므로, 스트리밍 테이블의 경우 사전에 조율이 필요합니다


## 3. 델타 테이블 기본 명령어


