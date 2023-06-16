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


### Chapter 6. 객체와 자료구조

#### p118. 자료 추상화
> 변수 사이에 함수라는 계층을 넣는다고 구현이 저절로 감춰지지 않는다. 구현을 감추려면 추상화가 필요하다
> 사용자가 구현을 모른 채 자료의 핵심을 조작할 수 있어야 진정한 의미의 클래스다
```java
// 인터페이스를 통한 추상화도 레벨이 다르다
public interface Vehicle {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();
}
// 추상적인 표현으로 표현하는 쪽이 더 낫다
public interface Vehicle {
    double getPercentFuelRemaining();
}
```

#### p119. 자료/객체 비대칭
* 객체는 추상화 뒤로 자료를 숨긴 채 자료를 다루는 함수만 공개한다
* 자료 구조는 자료를 그대로 공개하며 별다른 함수는 제공하지 않는다

```java
public class Square {
    public Point topLeft;
    public double side;
}

public class Rectangle {
    public Point topLeft;
    public double height;
    public double width;
}

public class Circle {
    public Point center;
    public double radius;
}

public class Geometry {
    public final double PI = 3.141592653589793;
    
    public double area(Object shape) throws NoSuchShapeException {
        if (shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.height * r.width;
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        } else {
            throw new NoSuchShapeException();
        }
    }
}
```
* 아래의 2가지 요구 사항에 대해 유지보수 비용이 큰 쪽은?
  * 새로운 도형인 Pentagon 클래스가 추가되는 경우? Geometry 클래스의 모든 함수를 수정해야 한다
  * 새로운 함수인 round 함수가 추가되는 경우? round 함수만 모든 자료 구조에 따라 구현하면 된다
> 즉, 자료 구조에 관대한 설계의 경우 새로운 기능의 추가에 용이하지만, 새로운 자료 구조 추가에 비용이 크다
> 자료 구조에 관대한 절차적인 코드 설계는 자료 구조에 의해 비용이 커진다

```java
public interface Shape {
    double area;
}

public class Square implements Shape {
    private Point topLeft;
    private double side;
    
    public double area() {
        return side * side;
    }
}

public class Rectangle implements Shape {
    private Point topLeft;
    private double width;
    private double height;
    
    public double area() {
        return width * height;
    }
}

public class Circle implements Shape {
    private final double PI = 3.141592653589793;
    private Point center;
    private double radius;
    
    public double area() {
        return PI * radius * radius;
    }
}
```
* 아래의 2가지 요구 사항에 대해 유지보수 비용이 큰 쪽은?
  * 새로운 도형인 Pentagon 클래스가 추가되는 경우? 새로운 Pentagon 클래스를 구현하기만 하면 된다
  * 새로운 함수인 round 함수가 추가되는 경우? 모든 클래스에 round 함수를 구현해야 한다
> 자료 구조에 엄격한 객체 지향적 설계는 새로운 자료 구조를 추가하는 데에 관대하나, 반대로 기능(함수)을 추가하는 비용이 커진다

* `자료 구조`와 `함수`의 추가에 모두 관대한 함수를 설계하기는 어려우며, 결국 비즈니스에 맞는 설계가 필요하다
  * 향후 새로운 `자료 구조`의 가능성이 높다면, `엄격한 자료 구조`를 가진 객체 지향적인 설계를
  * 그게 아니라 새로운 `기능` 혹은 `비즈니스 요구사항`이 불확실 하여 변경 및 추가가능성이 높다면 순수한 `자료 구조`를
> 결국 비즈니스가 명확하여 `Entity` 가 명확한 도메인 세계에서는 객체 지향 설계가 유지보수성이 높다고 판단되나
> 비즈니스가 불확실하고 해당 도메인의 `Entity` 가 언제든 추가될 수 있다면 너무 엄격한 객체지향 클래스화는 지양하는 것이 좋다

* `No Silver Bullet`
  * 노련한 객체 지향 설계자는 `Visitor` 혹은 `Dual-Patch`와 같은 기법을 통해 모든 `area` 함수 수정을 회피한다
  * `Visitor` 패턴은 주로 상속 없이 클래스에 메서드를 효과적으로 추가하기 위해 사용하지만,
  * 합성 객체의 내부 구조가 `Visitor` 에 열리게 되므로 캡슐화를 위반하는 문제가 생긴다
  * `객체가 중요하고 자주 추가/변경 된다면 객체지향, 객체는 변함없고 기능과 이벤트가 변화무쌍 하다면 절차지향`

#### p123. 디미터 법칙
> 잘 알려진 휴리스틱으로, 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다

```java
// getOptions(), getScratchDir(), getAbsolutePath() 호출을 하려면 해당 객체에 대한 확신이 있어야 한다
// 즉, 반환값의 내부구조가 노출되지 않고는 안전하게 사용할 수 없다는 말이 된다
final String outputDir = context.getOptions().getScratchDir().getAbsolutePath();

// 결국 다음과 같이 코드를 나누는 편이 좋다
Options options = context.getOptions();
File scratchDir = options.getScratchDir();
final String outputDir = scratchDir.getAbsolutePath();

// 단, getScratchDir() 의 반환값이 객체인 경우라면 노출되어서는 안 되지만, 자료 구조라면 디미터의 법칙이 적용되지 않는다
final String outputDir = contexst.options.scratchDir.absolutePath;
```
> 디미터의 법칙을 회피하기 위해서 비공개 변수를 사용하고자 하는 유혹에 빠져서는 안 된다

* 디미터의 법칙을 올바르게 이해하고 사용하는 방법은 왜 이러한 구조 혹은 함수 호출이 필요한 한지의 의도를 파악해야 한다
  * 왜 `getAbsolutePath` 호출을 하게 되었는지, 임시 파일을 생성하기 위함이라면 해당 기능을 추가할 수도 있다
  * 즉, 객체에 필요한 기능을 고려하여 추가하는 것이 적절한 파해법이다

#### p126. 자료 전달 객체 (Data Transfer Object)
> 자료 구조체의 전형적인 형태는 공개변수만 존재하고 함수가 없는 `DTO`가 있으며, 가장 일반적인 형태가 `Bean` 구조다
> private 변수를 get 메서드를 통해서만 접근할 수 있는 일종의 사이비 캡슐화 클래스이다

#### p127. 활성 레코드 (Active Record)
> 활성 레코드는 자료 전달 객체의 특수한 형태이며 `save`, `find` 같은 탐색함수도 제공된다. 활성 레코드는 데이터베이스 테이블이나
> 다른 소스에서 자료를 직접 변환한 결과이며, `활성 레코드`도 하나의 자료 구조로 취급한다. 
> 비즈니스 규칙을 담으면서 내부 자료를 숨기는 객체는 따로 생성한다 (내부 자료는 활성 레코드의 인스턴스일 수 있다)

* **객체와 자료구조**를 요약하면
  * `새로운 자료 타입을 추가하는 유연성이 필요하면 객체가 더 적합`
  * `새로운 동작을 추가하는 유연성이 필요하면 자료 구조와 절차적인 코드가 더 적합`


### Chapter 7. 오류 처리

#### p135 예외에 의미를 제공하라
* 실패한 코드의 의도를 파악하려면 호출 스택만으로 부족하다
  * 예외를 던질 때는 전후 상황을 충분히 덧붙인다. 그러면 오류가 발생한 원인과 위치를 찾기가 쉬워진다

#### p135. 호출자를 고려해 예외 클래스를 정의하라
* 외부 라이브러리 사용 시에 감싸기 기법을 활용하라
  * 감싸기 기법을 통한 예외처리는 외부 라이브러리와 프로그램 사이의 의존성을 줄여준다

#### p137. 정상 흐름을 정의하라
* 예외를 통한 기본값 처리는 특수 사례 패턴 (Special Case Pattern)을 검토
  * 예외를 던지는 `MealExpenses` 객체 대신 기본값 처리를 하는 `PerDiemMealExpenses` 라는 특수 사례 객체를 반환한다
```java
// 아래와 같이 예외를 활용한 경우는 코드가 논리를 따라가기 어렵게 만든다
try {
    MealExpenses expenses = expenseReportDao.getMeals(employee.getID());
    m_total += expenses.getTotal();
} catch (MealExpensesNotFound e) {
    m_total += getMealPerDiem();
}

// 기존 클래스를 상속하여 getMeals 함수에서 MealExpensesNotFound 예외는 pass 하고, getTotal 에서 기본값 처리를 한다
public class PerDiemMealExpenses implements MealExpenses {
    public int getTotal() {
    // 기본 값으로 일일 기본 식비를 반환한다.
    }
}
```

#### p138. null 값은 넘기지도 반환하지도 마라
* null 을 반환하는 코드로 호출자에게 문제를 떠넘기지 말라
  * `null 대신, 예외나 특수 사례 객체를 반환하라`
```java
// 호출자가 null 처리를 하지못하는 순간 많은 문제가 발생할 수 있다
public void reigsterItem(Item item) {
  if (item != null) {
    ItemRegistry registry = peristenStore.getItemRegistry();
    if (registry != null) {
      Item existing = registry.getItem(item.getID());
      if (existing.getBillingPeriod().hasRetailOwner()) {
        existing.register(item);
      }
    }
  }
}

// 전달받은 함수가 null 처리를 하지 않은 경우 NullPointerException 혹은 아래와 같은 예외를 고려하는 수고를 해야한다
public class ThrowsExceptionMetricsCalculator {
    public double xProjection(Point p1, Point p2) {
        if (p1 == null || p2 == null) {
            throw new InvalidArgumentException("p1 혹은 p2 는 null 일 수 없습니다");
        }
        return (p2.x - p1.x) * 1.5;
    }
}

// 단, 아래의 코드는 `java -ea <class-name>` 와 같이 enable assertion 옵션을 추가해야 예외를 잡을 수 있다
public class AssertionMetricsCalculator {
    public double xProjection(Point p1, Point p2) {
        assert p1 != null : "p1 은 null 값일 수 없습니다";
        assert p2 != null : "p2 은 null 값일 수 없습니다";
        return (p2.x - p1.x) * 1.5;
    }
}
```


### Chapter 8. 경계
> 모든 소프트웨어를 직접 바닥부터 개발하는 경우는 드물다. 때로는 상용 패키지를, 때로는 동료가 작성한 코드를 혹은 사내에 배포된 유관 부서의
> 코드를 사용하는 경우가 더 많다. 이 때에 어떤 식으로는 외부의 코드를 우리 코드에 깔끔하게 통합해야 하며, 이러한 소프트웨어의 경계를 잘 
> 관리하는 것이 중요하다

#### p144. 외부 코드 사용하기
* Casting 이 항상 나쁜 것은 아니며, Generics 가 항상 좋은 것도 아니다
  * `java.util.Map` 과 같은 자바객체를 사용함에 있어서도 필요에 따라 casting 의 불편함을 줄이기 위해 Generics 를 활용하기도 한다
  * 아래와 같은 Map 객체를 사용하는 코드가 있다고 가정하자
```java
Sensor s = (Sensor) sensors.get(sensorId);
// 위와 같이 Map 객체를 자주 사용한다면 반복되는 Casting 이 불편하여 Generics 적용을 고려할 수 있다
    
Map<String, Sensor> sensors = new HashMap<>();
Sensor s = sensors.get(sensorId);
// 하지만 이러한 Sensor 라는 구체 클래스가 경게를 넘어서 넘어다닌다면 인터페이스 변경에 비용이 커질 수 있다

public class Sensors {
    private Map sensors = new HashMap<>();
    
    public Sensor getById(String id){
        return(Sensor)sensors.get(id);
    }
}
```
> 이와 같이 Map 인터페이스가 변경되더라도 나머지 프로그램에는 영향일 미치지 않는 코드로 개선되었다. 단, 여기서 주의할 점은 
> Map 클래스를 사용할 때마다 캡슐화가 필요하다는 의미가 아니라, 인터페이스가 프로그램 간에 경계를 넘어서지 말게 하라는 의미이다

#### p149. 학습 테스트 활용하기
> 외부 API 및 프레임워크를 사용할 때에 학습을 위해 단위 테스트를 활용하는 경우가 많은데 이러한 코드를 계속 유지해야 하는 지 고민한 적이 있다
> 경우에 따라서 Spike Solution 이라는 이름으로 작성하고 삭제하는 경우도 많았는데, 대상 외부 프로그램의 버전을 업그레이드 할 때에 아주 유용
> 하게 활용될 수 있다는 것을 깨달았다. 이러한 경계 테스트를 위한 단위 테스트가 없다면 낡은 버전을 필요 이상으로 오래 사용하기 쉽게 된다

* 경계에 위치한 코드는 깔끔하게 분리하고, 기대치를 정의하는 테스트 케이스도 작성한다
* 통제가 불가능한 외부 패키지의 구현 대신 통제가 가능한 우리 코드(Interface)에 의존하는 게 안전하다
  * 우리 코드에서 외부 패키지를 세세하게 알 필요는 없다

### Chapter 9. 단위 테스트
> 실제 코드가 진화하면 테스트 코드도 변해야 하는데, 테스트 코드가 지저분할수록 변경하기 어려워진다. 또한 테스트 코드가 개발자 사이에서
> 가장 큰 불만으로 자리잡고 개발 일정에 가장 큰 변수로 비난받기 쉬우며, 결국 테스트 코드를 폐기하기에 이르는 경우도 많다
> 테스트 코드에 쏟아부은 시간이 문제가 아니라 테스트 코드를 마음대로 짜도 된다고 생각한 것이 문제였고, 테스트 코드는 실제 코드 못지 않게
> 중요하다. 즉, 테스트 코드를 깨끗하게 유지하지 않으면 결국은 잃어버린다. 그리고 테스트 케이스가 없다면 모든 변경이 잠정적인 버그다
> `아키텍처가 아무리 유연하고 설계가 잘 되어 있어도 개발자는 변경을 주저하고, 새로운 도전을 하기 두려워할 수 밖에 없다`

#### p155. TDD 법칙 세 가지
* 실패하는 단위 테스트를 작성할 때까지 실제 코드를 작성하지 않는다
* 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다
* 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다

> 테스트 커버리지가 높을수록 공포는 줄어들고, 아키텍처가 부실하고 코드나 설계가 모호하더라도 별다른 우려없이 변경할 수 있다
> 오히려 안심하고 아키텍처와 설계를 개선할 수 있다. 

* 실제 코드를 점검하는 자동화된 단위 테스트 슈트는 설계와 아키텍처를 최대한 깨끗하게 보존하는 열쇠다.
* 테스트는 유연성, 유지보수성, 재사용성을 제공하며, 테스트 케이스가 있으면 **변경**이 쉬워지기 때문이다

#### p158. 깨끗한 테스트 코드
> 가독성을 높이려면, 명료성, 단순성, 풍부한 표현력이 필요하다

```java
class TestPage () {
  // original
  public void testGetPageHierachyXml() {
    crawler.addPage(root, PathParser.parse("PageOne"));
    crawler.addPage(root, PathParser.parse("PageOne.ChildOne"));
    crawler.addPage(root, PathParser.parse("PageTwo"));
    
    request.setResource("root");
    request.addInput("type", "pages");
    Responder responder = new SerializedPageResponder();
    SimpleResponse response = (SimpleResponse) responder.makeResponse(
        new FitNessecontext(root), request);
    String xml = response.getContent();
    
    assertEquals("text/xml", response.getContentType());
    assertSubString("<name>PageOne</name>", xml);
    assertSubString("<name>PageTwo</name>", xml);
    assertSubString("<name>ChildOne</name>", xml);
  }
  
  // refactored w/ build-operate-check pattern
  public void testGetPageHierarchyAsXml() {
      makePages("PageOne", "PageOne.ChildOne", "PageTwo");
      
      submitRequest("root", "type:pages");
      
      assertResponseIsXML();
      assertResponseContains("<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>");
  }
}
```
> 이와 같은 경우에 build-operate-check 패턴이 적합하며, 잡다하고 세세한 코드는 모두 없앴다는 사실에 주목해야 한다
> 테스트 코드는 본론에 돌입해 진짜 필요한 자료 유형과 함수만 사용해야 세세한 코드에 주눅들고 헷갈릴 필요없이 이해할 수 있어야 한다

```java
class EnvironmentControllerTest {
    
  @Test
  public void turnOnLowTempAlarmAtThreshold() throws Exception {
    hw.setTemp(WAY_TOO_COLD);
    controller.tic();
    assertTrue(hw.heaterState());
    assertTrue(hw.boilerState());
    assertTrue(hw.coolerState());
    assertFalse(hw.hiTempAlarm());
    assertFalse(hw.loTempAlarm());
  }
  
  @Test
  public void turnOnLoTempAlarmAtThreshold() throws Exception {
      wayTooCold(0);
      assertEquals("HBchL", hw.getState());
  }
}
```
> 실제 환경에서는 절대로 안 되지만 테스트 환경에서는 용인할 만한 방법들도 많다. 즉 테스트하기에 최적화된 코드가 테스트 코드에 맞는 코드다

#### p164. 테스트 당 assert 하나
> 물론 given-when-then 규칙에 따라 하나의 단위 테스트에 하나의 assert 만 구성하는 것이 좋지만, 경우에 따라서는 중복이 많아질 수 있겠다
> 이러한 경우 Template Pattern 등을 활용하여 개선할 수 있겠다

* `테스트 함수마다 한 개념만 테스트하라` 가 적합한 접근일 수 있겠다

#### p167. F.I.R.S.T

* 빠르게 (Fast) : 테스트가 느리면 자주 돌릴 엄두를 못 내며, 자주 돌리지 못하면 초반에 문제를 빠르게 찾거나 수정하기 어렵게 된다
* 독립적으로 (Independent) : 각 테스트 들은 서로 의존해서 안되며, 독립적으로 순서와 병렬 수행과 무관하게 동작해야만 한다
* 반복가능하게 (Repeatable) : 실제 환경, QA 환경, 버스를 타고 집에가는 길에 사용하는 노트북에서도 실행될 수 있어야만 한다 (외부 의존 제거)
* 자가검증하는 (Self-Validating) : 테스트는 부울(bool) 값으로 결과를 내어야지, 파일을 읽거나 파일을 서로 비교하는 등의 작업은 위험하다
* 적시에 (Timely) : 실제 코드를 구현하기 직전에 구현해야지, 구현 후에 단위테스트는 불가능할 수도 있고, 테스트하기 어려워지기 쉽다

> 테스트 코든느 실제 코드만큼이나 프로젝트 건강에 중요하다. 어쩌면 실제 코드보다 더 중요할지도 모르겠다. 테스트 코드는 실제 코드의 유연성, 
> 유지보수성, 재사용성을 보존하고 강화하기 때문이다. 그러므로 테스트 코드는 지속적으로 깨끗하게 관리하고, 표현력을 높이고 간결하게 정리하자

