# Clean Code
> [Clean Code](https://www.yes24.com/Product/Goods/59626179) '애자일 소프트웨어 장인 정신' 책을 읽고 마음에 남는 구절 정리


### Chapter 1. 깨끗한 코드
#### p4. Clean Code
* 궁극적으로 코드는 요구 사항을 표현하는 언어다
  * 이러한 요구 사항은 기계가 내는 것이 아니라 사람이 낸다
  * 결국 사람과 기계를 이어주는 역할이 프로그래머다
* 급해서, 서두르다 짠 나쁜 코드가 회사를 망하게 한다
  * 르블랑의 법칙 (Leblanc's Law), Later equals never
  * 빅브라더는 좋은 코드인가? 유지보수 하기 좋은가? 읽기 좋은가? 이번 버그 발견이 어려웠던 이유는 무엇인가? 새로 짠다고 해서 적절한 시간 내에 더 잘 짤 수 있는가?
* 좋은 코드를 사수하는 것은 프로그래머의 책임이다
  * 어느 환자가 수술 전에 시간을 아끼기 위해 손을 씻지 말라고 한다면 당신이 의사라면 어떻게 할 것인가?
  * 환자를 가장 잘 아는 사람은, 의학 지식이 가장 많은 사람은 의사이다
  * 기한을 맞추는 유일한 방법은 최대한 코드를 깨끗하게 유지하는 습관이다
* 깨끗한 코드를 구현하는 행위는 그림을 그리는 것과 같다 
  * 좋은 그림과 나쁜 그림은 누구나 쉽게 구별할 줄 알지만, 아는 것과 할 줄 아는 것은 다르다 
  * 깨끗한 코드를 작성하는 프로그래머는 빈 캔버스를 우아한 작품으로 바꿔가는 화가와 같다 
* Bjaren Stroustrup says 나는 우아하고 효율적인 코드를 좋아한다 
  * 논리가 간단해야 버그가 숨어들지 못한다. 
  * 의존성을 최대한 줄여야 유지 보수가 쉬워진다. 
  * 오류는 명백한 전략에 의거해 철저히 처리한다. 
  * 성능을 최적으로 유지해야 사람들이 원칙 없는 최적화로 코드를 망치려는 유혹에 빠지지 않는다. 
  * 깨끗한 코드는 한 가지를 제대로 한다 

#### p8, 깨끗한 코드는 예술
* 깨끗한 코드는 단순하고 직접적이다. 깨끗한 코드는 잘 쓴 문장처럼 읽힌다 
* 깨끗한 코드는 작성자가 아닌 사람도 읽기 쉽고 고치기 쉽다. 
* 단위 테스트 케이스와 인수 테스트 케이스가 존재한다 
* 아무리 가독성이 높아도, 테스트 케이스가 없으면 깨끗하지 않다 
* 중복과 표현력만 신경 써도 깨끗한 코드라는 목표에 성큼 다가선다 
  * 중복을 피하라
  * 한 기능만 수행하라
  * 제대로 표현하라
  * 작게 추상화하라
* 새 코드를 짜면서 우리는 끊임없이 기존 코드를 읽는다 
* 코드를 읽는 시간 대 코드를 짜는 시간 비율이 10대 1을 훌쩍 넘는다 
* 급하다면, 서둘러 끝내려면, 쉽게 짜려면, 읽기 쉽게 만들면 된다 

#### p18. 보이스카웃 규칙
* 캠프장은 처음 왔을 때보다 더 깨끗하게 해놓고 떠나라
* 시간이 지날수록 코드가 좋아지는 프로젝트에서 작업한다고 상상해 보라
* Agile Software Development: Principles, Patterns, and Practices
  * SRP Single Responsibility Principle
  * OCP Open Closed Principle
  * DIP Dependency Inversion Principle


### Chapter 2. 의미있는 이름
#### p25, 의미 있는 이름
* 의미 있게 구분하라
  * moneyAmount 는 money 와 구분이 안 된다
  * a, an, the 와 같이 data, info, object 등은 모호한 단어다
  * PhoneNumber phoneString 은 더 이상 문자열이 아니다
* 발음하기 쉬운 이름을 사용하라
  * ymdhms != yyyyMMddHHmmSS --> timestamp
* 인터페이스 클래스와 구현 클래스
  * ShapeFactoryImpl 이 CShapeFactory 와 IShapeFactory 보다 낫다 (IDE 코드 정렬 때문에 보기에도 낫다)
* 클래스 이름은 명사나 명사구가 적합하다
  * Customer, WikiPage, Account, AddressParser 는 적합
  * Manager, Processor, Data, Info 등은 피하고, 동사는 금물
* 메서드 이름은 동사나 동사구가 적합하다
  * postPayment, deletePage, save 는 적합
  * 접근자 Accessor, 변경자 Mutator, 조건자 Predicate 는 java bean 표준에 따라 get, set, is 를 붙인다
  * 생성자 override 시에는 정적 팩토리 메서드를 사용한다
    * Complex fulcrumPoint = Complex.FromRealNumber(23.0); (좋은 예)
    * Complex fulcrumPoinst = new Complex(23.0); (나쁜 예)

#### p33, 한 개념에 한 단어를 사용하라
* 동일한 프로젝트에서 일관성 있는 메서드 및 클래스 이름을 사용해야 직관적이다
  * Controller, Manager, Driver 등은 구분하기 어렵다
  * plus 의미와 insert 의미로 add 사용은 의도가 불명확 하다
  * domain 보다 it 및 math 영역 단어는 명확하다
* 좋은 이름을 선택하려면 설명 능력이 뛰어나야 하고 문화적인 배경이 같아야 한다
* 코드 가독성이 높아지는 이름을 선택하라


### Chapter 3. 함수
#### p42, 작게 만들어라
* 이 정도 작으면 봐 줄만 하다
```java
// HtmlUtil.java
public static String renderPageWithSetupAndTeardowns(
  PageData pageData, boolean isSuite) throws Exception {
    if (isTestPage(pageData))
      includeSetupAndTeardownPages(pageData, isSuite);
    return pageData.getHtml();
  }
```
* 왠지 작은 페이지에서도 잘 보여 설득력 있다
* if, else 등은 내가 좋아하듯이 bracket 없는 1 라인 

#### 단순화 기준
* 중첩 구조가 생길 만큼 커져서는 안 된다
* 한 가지 일만 하는 함수는 섹션을 나누기 어렵다
* 하나의 함수 내에서 추상화 수준이 다르면 코드 읽기가 어렵다

2023/05/30, Clean Code
```java
// Payroll.java
// 1. 새로운 직원 유형이 추가될 때마다 수정이 필요하다 - OCP
public Money calculatePay(Employee e) throws InvalidEmployeeType {

// 2. 구현이 외부로 노출되며, 한 가지 작업만 하지 않는다 - SRP
switch (e.type) {
  case COMMISSIONED:
    return calculateCommissionPay(e);
  case HOURLY:
    return calculateHourlyPay(e);
  case SALARIED:
    return calculateSalariedPay(e);
  default:
    throw new InvalidEmployeeType(e.type);
  }
}

// 1. Employee 클래스를 확장할 수 있도록 추상화 한다
public abstract class Employee {
  public abstract boolean isPayday();
  public abstract Money calculatePay();
  public abstract void deliveryPay(Money pay);
}

// 2. 인터페이스를 통해 내부구현을 노출하지 않는다
public interface EmployeeFactory {
  public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
}

// 3. makePay 함수를 기능을 가진 다수의 객체를 반환하도록 확장한다
public class EmployeeFacdtoryImpl implements EmployeeFactory {
  public Employee makeEmployee(EmployeeRecord R) throws InvalidEmployeeType {
    switch (e.type) {
    case COMMISSIONED:
      return new CommissionEmployee(r);
    case HOURLY:
      return new HourlyEmployee(r);
    case SALARIED:
      return new SalariedEmployee(r);
    default:
      throw new InvalidEmployeeType(r.type);
    }
  }
}
```

#### p47. Switch 문
* 작게 만들기 어렵고, 새 유형이 추가되기 쉬우며, 여러가지 작업을 하는 경우가 많다. 특히 SRP, OCP 원칙에 위배된다
* 상속 관계로 숨기고 다른 코드에 노출되지 않는 방식으로 개선한다

#### p49. 서술적인 이름을 사용하라
* 코드를 읽으면서 짐작했던 기능을 각 루틴이 그대로 수행한다면 깨끗한 코드
* 길고 서술적인 이름이 길고 서술적인 주석보다 좋다
* 이름을 정하느라 시간을 들여도 괜찮다
* 하나의 모듈 내에서 일관성 있는 동사, 명사를 사용한다
* Refactoring 과정은 제대로 이해하고 원칙을 지키기 위한 공식 혹은 패턴을 손으로 익혀두지 않으면 바로 써먹기 어렵다

#### p50 함수 인수
* 특별한 이유가 있어도 4개 이상의 인수를 가진 함수는 금지
  * 단위 테스트도 어렵고, 코드 읽기가 지옥이다
  * 인수가 없거나 1개 정도가 가장 적절하다
  * setupTearDownIncluder.render(pageData)
* 플래그 인수 대신 기능을 분리한 함수를 구현하라
  * 대놓고 한 번에 여러 기능을 가진 샘이다
  * render(boolean isSuite) 대신
    * renderForSuite() 와 renderForSingleTest() 분리
  * 출력 인수를 명확하게 사용하라
    * appendFooter(String s) s 에 넣는지, s 가 들어가는지?
    * this.appendFooter() 와 같이 명시적으로 구현한다
  * 3개 이상의 인수는 별도 class 도입을 검토하라
  * 동사와 키워드를 적극 활용한 함수 이름을 작성하라
    * write(String name) 보다 writeField(String name)
    * assertEquals(e, a) 보다 assertExpectedEqualsActual(e, a)

#### p54 부수 효과를 일으키지 마라
* 함수의 이름에서 드러나지 않는 어떤 이벤트도 발생해서는 안 된다
* password 체크 함수에서 session 초기화가 일어난다면?

#### p56 명령과 조회를 분리하라
* 함수는 뭔가 수행하거나 뭔가 답하거나 둘 중 하나만 해야 한다
* 속성을 설정하고 결과를 반환하는 2가지 기능을 분리
* 함수는 그 언어에서 동사며, 클래스는 명사다
```java
// if attribute exists ..
if (attributeExists("username")) {
  setAttribute("username", "unclebob");
}
```


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


### Chapter 5. 형식 맞추기
> 코드 형식은 중요하다 ! 너무 중요해서 무시하기 어렵다. 너무나도 중요하므로 융통성 없이 맹목적으로 따르면 안 된다
> `코드 형식은 의사소통의 일환이다. 의사소통은 전문 개발자의 일차적인 의무다`

#### p96. 적절한 행 길이를 유지하라
> Tomcat 과 Ant 는 절반 이상이 200줄을 넘어서고 심지어 수천 줄이 넘어가는 파일도 있다. 
> JUnit, Time and Money 는 500줄을 넘어가는 파일이 없으며 대다수가 200줄 미만이다.
> 500줄을 넘지 않고 대부분 200줄 정도인 파일로도 커다란 시스템을 구축할 수 있다는 사실이다

* 신문 기사처럼 작성하라
  - 이름은 간단하면서도 설명이 가능하게
  - 아래로 내려갈수록 의도를 세세하게 묘사
* 개념은 빈 행으로 분리하라
  - 줄바꿈은 개념의 묶음 즉 하나의 생각을 분리한다
* 세로 밀집도, 수직 거리, 종속 함수 그리고 개념적 유사성
  * 연관성 있는 변수는 가까이 선언
  * 연관성 있는 함수와 클래스는 하나의 파일에 유지
  * 변수는 사용하는 위치에서 최대한 가까이에 선언
  * 반면 인스턴스 변수는 클래스의 맨 처음에 선언
  * 한 함수가 다른 함수를 호출한다면 두 함수는 세로로 가까이 배치
  * 호출하는 함수를 호출되는 함수보다 먼저 배치 (like newspaper)
  * 비슷한 동작을 하는 함수를 가까이에 선언

#### p107. 가로 형식 맞추기
> 20자에서 60자 사이의 코드가 총 행 수의 약 40%에 달하며, 명백하게 짧은 행을 선호한다 (80~120이 최대 한도)

* 맥락과 읽기 편의성을 고려한 가로 공백과 밀집도
  * 할당 연산자를 강조하려고 앞뒤에 공백을 둔 반면 함수와 괄호 사이에는 공백이 없다
* 가로 정렬
  * 탭이나 공백을 통한 변수끼리 정렬은 변수와 타입간의 맥락을 떨어뜨리는 효과가 있어 유용하지 못하다 (선언부가 길다면 쪼개야 하는 신호)
* 들여쓰기
  * 범위(scope)로 이루어진 계층을 위한 표현이므로 한 줄쓰기의 유혹에 빠지지 않길 바란다
```java
  public CommentWidget(ParentWidget parent, String text) {super(parent, text);}
  public String render() throws Exception { return ""; }

  // 함수간에 공백, 명시적인 들여쓰기를 통해 범위를 제대로 표현할 수 있다
  public CommentWidget(ParentWidget parent, String text) {
    super(parent, text);
  }

  public String render() throws Exception {
    return "";
  }
```
* 가짜 범위 - 마지막에 세미콜론 (;)을 통한 신경써야 하는 형식을 피하라
```java
while (dis.read(buf, 0, readBufferSize) != -1)
;
```

#### p113. 팀 규칙
> 팀 규칙이란느 제목은 말 장난이다. 프로그래머라면 각자 선호하는 규칙이 있지만, `팀에 속한다면 자신이 선호해야 할 규칙은 바로 팀 규칙이다`
> 팀은 한 가지 규칙에 합의해하 하고, 모든 팀원은 그 규칙을 따라야 한다. 그래야 소프트웨어가 일관적인 스타일을 보인다.
> 프로젝트를 시작할 때 자리, 클래스와 변수, 메서드 이름 규칙 등을 정하고 IDE 코드 형식기를 설정하고 모두 따라야 한다


