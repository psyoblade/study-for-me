# The Nature of Software Development

# '작동하는 소프트웨어를 보여주세요'

## '가치'는 우리가 원하는 것
* 작동하는 소프트웨어를 보여주세요
* 소프트웨어를 배포할 때 비로소 가치는 생겨납니다
  * MMF (Minimum Marketable Feature) 조각으로 배포할 것
* 가장 높은 가치를 가진 조각을 가장 먼저 배포하세요
* **피처들은 가치를 전달하며 빠르게 전달할 수 있다면 그만큼 가치를 얻을** 수 있습니다

## 피처 단위 개발을 위한 가이드라인
* 피처 단위로 프로젝트를 진행한다면 더 잘 예측할 수 있다
  * 눈으로 확인할 수 있는 피처를 배포하세요
* **가치(피처)를 기준으로 프로젝트를 관리하는 방법**이 가치를 전달하지 못하는 방법 보다 효과적입니다

## 피처 단위로 조직 구성하기
* 학습 공동체를 만드세요
  * 선임개발자가 후임을 이끌어서 전문성을 가질 수 있게 하기에 선임자

## 피처 단위로 계획하기
* 계획은 쓸모없을 떄가 많습니다. 하지만 동시에 없어서는 안 될 부분입니다
  * 이것이 없으면 안되는 핵심개발 피처를 선정하고 기록하는 것이 가장 중요하다
* 세부계획은 필요 없습니다
  * 가장 중요하고 가치있는 피처를 우선으로 언제든 배포할 수 있는 상태의 제품을 개발합니다
* **1~2주를 하나의 스프린트로 완전히 돌아가는 제품을 개발**
  * 각각의 피처는 2~3일 정도의 작업을 할 분량일 때 가장 좋은 결과를 낼 수 있습니다
  * 2주 스프린트에 3~4개 정도의 핵심 피처가 수행될 수 있도록 피처를 쪼개야 한다
* **'어제의 날씨' 방법**을 통해 예측합니다
  * 오늘은 어제의 업무량만큼 일할 수 있다는 원리를 반복 개발주기를 사용하는 프로젝트에 적용합니다
  * 업무량은 개발 주기가 시작되기 직전에 계획하되, 피처에 대한 모든 팀원의 완전한 이해가 필요합니다
* 추정은 위험합니다
  * 사람에 따라 상황에 따라 달라지는 과장과 비교를 피하기 위해서 추정하지 않습니다
  * 대신, 해야할 일을 잘개 쪼개고, 단순히 완료된 것을 세어보는 것만으로 추측이 가능합니다
* 무리한 목표는 자멸하는 길
  * 서두름은 지저분한 코드를, 그러한 코드는 더 많은 결함을 가지기 마련입니다
  * 압박은 프로젝트를 실패로 이끄는 지름길입니다
  * 자주 계획하고 다음에 할일을 정하는 것

## 피처 단위로 개발하기
* 작지만 완전한 제품을 완성하세요
  * 짧게는 1주 또는 2주 정도로 계획합니다
  * 주기마다 개발해야 할 피처와, 그 피처의 테스트 방법을 정리해야 합니다
  * 완전한 제품이란 계획한 기능을 개발하고 테스트를 통과한 제품을 말합니다
* 제품이 가진 특징을 가다듬으세요
  * **반드시 있어야 하는 피처**와 단순히 **있으면 좋은 피처**를 구분하면 제품의 특징이 더욱 뚜렷해 집니다
* 가장 높은 가치를 가진 피처를 먼저 개발하세요
  * 어떤 피처가 더 적은 비용으로 높은 가치를 주는지 구분하기 위해 모든 팀원이 노력해야 합니다
  * 모든 피처는 **완료**와 **미완료**로 구분됩니다 80% 완료는 없습니다
  * 매 주기 마다 배포할 수 있는 제품이 나와야 하며, 결함이 없다는 것을 확신할 수 있어야 합니다
* 제품이 성장할 때마다 설계를 확장하고 개선해야 합니다
  * 피처 단위 개발을 진행하는데 결함이 없는 것만으로 충분하지 않습니다
  * 제품이 성장할 때마다 소프트웨어의 설계도 개선해야 합니다
  * 작업 속도를 잘 관찰하여 너무 많은 혹은 적은 설계는 작업속도를 늦추기 마련입니다

## 피처와 기반을 동시에
* 가치를 전달하기 위한 핵심 피처를 우선 완성해야 합니다
  * '기반'의 의미는 '아키텍처', '디자인' 혹은 '인프라' 라고도 말합니다
* 설계와 피처 사이에 균형 맞추기
  * 기반을 먼저 구성하면 너무 적은 피처로 제품을 배포하게 되어 프로젝트 예측이 불가능합니다
  * 가능한 모든 피처를 개발하는 것이 옳지 않은 것처럼, 각 피처가 가진 모든 가능성을 고려해서 개발해서도 안 됩니다
  * 제품의 만족도는 사용자가 만족하고 매력을 느낄 수 있는 완전하고 멋진 피처들에 달려 있기 때문입니다
* 간결하지만 작동하는 버전을 먼저 개발하세요
  * 일정 내에 가능한 피처를 선택하고 개발해야 합니다
  * 반드시 필요한 간결한 피처를 활용해 만든 제품이 MVP(Minimum Viable Product)라고 합니다
* 몇 번의 개발 주기로 피처를 개선하세요
  * MVP 에서 같은 기능을 수행하는 피처를 개선하는 작업을 반복해서 품질을 향상시킵니다
* 원하는 배포 일정에 가능한 최고의 산출물을 배포할 수 있게 진행하세요
  * 제품 책임자는 다음 주기에 개발할 피처를 선택하는 연습을 반복하여 훈련해야만 합니다
  * 제품 개발자는 이러한 주기를 잘 수행하기 위해 어떤 기술 능력을 키워야 할까요?

## 무결점과 견고한 설계
* 올바로 작동하는 피처를 늘려 제품을 만듭니다
  * 동작하는 최소 기능 제품을 개발하되
  * 점진적으로 발전하는 설계에 기반을 두고 개발해야 합니다
  * 모든 피처가 제대로 작동하면서 설계가 확장되어야 합니다
* 오직 **테스트만이 결함을 발견하고 없앨 수 있는 유일한 방법**입니다
  * 개발주기를 거듭하고, 시스템이 성장할 수록 더 많은 테스트를 거쳐야 합니다
  * 개발자는 반드시 실제로 자동하는 피처들을 배포해야 합니다
* 테스트는 비즈니스와 개발자 관점으로 나눠서 진행합니다
  * 개발 주기가 끝날 때마다 반드시 비즈니스 테스트를 수행합니다
  * 테스트 시에는 이전 주기에 추가된 피처에 대해서도 확인해야 합니다
  * 비즈니스 관점에서 자동으로 테스트를 수행하는 인수테스트 주도 개발 (ATDD, Acceptance Test-Driven Development)을 검토할 수 있습니다
  * 개발자 관점에서는 테스트 주도 개발(TDD, Test-Driven Development)이 설계를 개선해준다는 점에서도 아주 유용합니다
  * 실수를 줄이고 결함을 더 빨리 찾을 수 있기에 개발 속도를 향상시킵니다
* 피처 단위로 제품이 성장할수록 설계도 함께 성장해야 합니다
  * 피처를 개발할 때마다 설계를 개선해야 합니다
  * 올바른 설계를 유지하는 일을 '리팩토링'이라고 합니다
* 이 개발방법의 본질은 '테스트'와 '리팩토링'에 있습니다