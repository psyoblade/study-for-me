# Delta Lake
> [Delta Lake: Up and Running](https://www.yes24.com/Product/Goods/118729571) 읽고 정리.


## Prologue. 
> 너무 세세한 기술적인 내용 보다는 비즈니스 (돈, 시간, 인적/물적 리소스 등)관점에서 어떤 이득을 얻을 수 있는 지를 파악하고 리뷰할 것

### 1. 델타 레이크 인터넷 자료

* [델타 레이크](https://learn.microsoft.com/ko-kr/azure/databricks/delta/best-practices) 프레임워크의 주요 기능
  - 낮은 Cardinality 열은 Partition-by 활용 높은 Cardinality 경우는 Z-order 활용한 성능 개선을 기대할 수 있다
  - ACID Transaction 보장과 함께 Optimize 및 Vacuum 명령을 통해 압축 및 최적화를 기대할 수 있습니다
  - Upsert, Delete 및 Metadata API 지원
  - Atomic 한 테이블 스키마 및 데이터 교체 지원
  - 반면에 Spark Cache 기능 사용 시에 여러 side-effect 가 있으므로 사용하지 않는 것을 권장합니다
  - 항상 freshness 상태를 지원하고, 파티션 상태 및 단일 파티션 로딩 및 트랜잭션 지원
* [Real-time data warehousing with Apache Spark and Delta Lake](https://www.sigmoid.com/blogs/near-real-time-finance-data-warehousing-using-apache-spark-and-delta-lake/) 활용사례
  - Capturing the transaction details - 기존 관계형 데이터베이스, 카프카 혹은 파일의 경우 이력을 알 수 없어 이슈 발생 시에 역추적이 어렵다
  - Encryption of the transaction information - 트랜잭션 정보의 암호화
  - Routing to the payment processor - 결제 처리 업체 혹은 부서로 전달이 가능하고
  - Return of either an approval or a decline notice. - 승인 혹은 거부 알림 전달이 가능하다
* [Real-Time Data Processing with Delta Live Tables: Use Cases and Best Practices for Databricks](https://matthewsalminen.medium.com/real-time-data-processing-with-delta-live-tables-use-cases-and-best-practices-for-databricks-2009a9a6fc16) 델타 라이브 테이블의 장점
  - Real-Time: 데이터가 도착하는 대로 처리하고 분석하여 스트리밍 데이터의 배치 처리에 의한 지연을 제거할 수 있습니다
  - Data Quality Assurance: 여러 제약 조건 등을 활용하여 무결성과 품질을 보장합니다
  - Multi-Hop Architecture: 데이터 등급(메달리온 아키텍처)에 따른 다중 계층 데이터 파이프라인 및 아키텍처를 지원을 통해 사용성, 성능 및 관리 효율성이 높아집니다
* [게임의 성공을 위한 Scalable 한 데이터 플랫폼 사례](https://www.slideshare.net/awskorea/scalable-games-on-aws-2022)
  - parquet 기반의 테이블의 format 한계에 의한 비효율성 감소 (저장 공간, 성능, 파일 수 등)
  - 다양한 분석가 사용자들의 Live Table 사용 가능
  - 스트림 소스를 파일 시스템으로 하고, 카프카 클러스터와 decoupling 통해 카프카 장애가 서비스에 직접적인 영향이 없음
  - 로그 소비자가 카프카 인터페이스를 몰라도 사용할 수 있음
* [Delta Lake를 사용한 GDPR 및 CCPA 규정 준수](https://learn.microsoft.com/ko-kr/azure/databricks/security/privacy/gdpr-delta)
  - 기존에 immutable 한 parquet 포맷 특성 상 가명화 및 일부 수정의 어려움이 있으나 해소

### 2. 델타 레이크의 비즈니스 적인 가치

* 델타가 가진 가장 핵심적인 기능은 아래의 몇 가지 정도라고 볼 수 있다
  * 분산저장 환경에서 ACID 한 CRUD 트랜잭션을 지원하는 파일시스템
  * 아카이브 로그 방식으로 저장 관리되어 과거 이력추적 및 특정 시점으로 돌아갈 수 있다
  * 스트리밍 저장을 통해 파편화된 파일들을 압축 및 삭제가 가능하다
* 이러한 기능들을 활용하여 기존에 갖지 못했던 가치를 제공해줄 수 있다고 생각한다
  * 빠른 데이터 전달과, 성능을 고려하여 제공하던 분단위/시간단위 게임로그를 하나로 통합하여 저장공간 및 운영 비용을 줄일 수 있다
  * 트랜잭션을 지원하는 열 단위의 수정이 가능하여 GDPR 문제 혹은 민감 데이터 가명화 등을 바로 적용할 수 있어 저장공간 및 리소스 사용 최소화
  * 트랜잭션 레벨에서 이력 확인 및 롤백이 가능하여, 장애 및 이슈 발생시에 즉각적인 조치 및 최소한의 수정으로 빠른 대응이 가능
  * 라이브 스트림 테이블 사용이 가능하면 스트림 소비자의 경우 카프카에 직접접속하지 않아도 되며 생산자 입장에서도 클러스터 관리에 용이함
  * 수정불가한 파케이 기반의 테이블의 경우 조회와 가공을 동시에 할 수 없기에 중복 데이터를 유지하거나, 레퍼런스를 사용하는 개발/운영비용 감소
  * 카프카 클러스터의 장애 시에도 원본 스트림 소스를 델타로 두는 경우 서비스의 영향도를 최소화 할 수 있으며 인프라와의 디커플링도 가능함
* 델타 레이크 적용을 위해 감수해야 하는 부담과 변경 사항에는 이런 것들이 있다
  * 기존 파케이 방식의 테이블을 모두 델타 방식으로 변경해야 하므로 단계별로 유용한 경우에만 적용할 수 있다
  * 하이브 및 다양한 하둡 에코시스템에서 델타를 지원하기 위한 기본 라이브러리를 제공하지 않아 개별적인 배포 및 검증이 필요하다
  * 경우에 따라서 델타 연동이 어렵거나 문제가 된다면 제한적으로만 사용할 수도 있다
