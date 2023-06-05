# Clean Code

### Chapter 4. 주석
#### p68. 나쁜 코드에 주석을 달지 마라. 새로 짜라.
* 주석은 순수하게 선하지 못하며, 사실상 주석은 기껏해야 필요악이다
* 주석 없이는 코드로 표현할 방법이 없기에 마지못해 사용하는 것
* 부정확한 주석은 아예 없는 주석보다 훨씬 더 나쁘다
* 코드로 의도를 표현하라
    ```java
    // 직원에게 복지 혜택을 받을 자격이 있는지 검사한다
    if ((employee.flags && HOURLY_FLAG) && (employee.age > 65)) {...}
    if (employee.isEligibleForFullBenefits()) {...}
    ```
* 이해가 안 되어 다른 코드를 뒤져야 하는 주석은 독자와 제대로 소통하지 못하는 주석이다

#### p81. 이력을 기록하는 주석
* 과거 소스 코드 관리 시스템이 없었을 때에는 몰라도 이제는 혼란만 가중 할 뿐이다.

#### p84. 함수나 변수로 표현할 수 있다면 주석 대신 풀어서 작성하라
* 주석에 의존한 한 줄의 코드와 한줄의 주석 대신
```java
// 전력 목록 <smodule>에 속하는 모듈이 우리가 속한 하위 시스템의 의존하는가?
if (smodule.getDependSubsystems().contains(subSysMod.getSubSystem()))
```
* 3줄의 코드로 풀어서 표현하는 것이 더 건강한 코드다
```java
    ArrayList moduleDependees = smodule.getDependSubsystems();
    String ourSubSystem = subSysMod.getSubSystem();
    if (moduleDependees.contains(outSubSystem))
```
* 닫는 괄호에 다는 주석 대신 코드를 줄여라
* 주석으로 처리한 코드 만큼 독자를 불안하게 만드는 코드는 없다
  - 삭제해도 소스 관리자가 기억한다
* 공개 코드에서는 Javadocs 가 유용하지만 공개하지 않을 코드라면 쓸모가 없다.
