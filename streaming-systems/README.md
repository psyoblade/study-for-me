# Streaming Systems
> 2024.12.3 부터 읽기 시작

## 1. 스트리밍 101
* 스트리밍 시스템의 속성 중에 가장 중요하다 생각하는 것이 unbounded dataset 을 다룬다는 점과, 끊임없는 streaming data 처리에 있다
  * 이러한 스트리밍 처리를 잘 다룬다는 것은 streaming 처리를 batch 와 같이 다룰 수 있도록 하는 것에 있는 것 같다
  * unbounded 를 bounded 처럼 streaming 데이터를 항상 idempotence 보장을 할 수 있도록 프레임워크를 구성하는 데에 있다고 생각한다
* 스트리밍 시스템이 전통적인 배치 시스템과의 가장 큰 차이점은 unbounded unordered 특성을 가진다는 것이다
  * 대표적인 스트리밍 저장소 카프카를 보더라도 그러한 특성을 가지면 이러한 제약을 극복할 수 있도록 구성해야 한다

## 11. Q&A
### Q1 원본 스트리밍 소스로부터 직접 최종 저장소에 저장하는 방법이 더 간결한데 왜 스트리밍 파이프라인을 구성하면 좋은가?
  * 스파크 스트리밍 같은 분산 프레임워크를 사용하기에 좋으며, 저장 포맷에 자유로울 수 있다
  * 데이터소스에 구현된 프레임워크 엔진의 최적화 기능을 활용할 수 있다
  * 스트리밍 데이터를 배치 데이터처럼 처리할 수 있고 항상 멱등한 결과를 내기에 용이하다
  * 사용하기 편한 스트리밍 원본 소스를 제공할 수 있다 (다만, 카프카를 영구적인 스트리밍 소스로 사용하기는 어렵다)