package me.suhyuk.study.cleancode.apps;

/* Created by psyoblade on 2023-06-14 */
public class FooApp {

    // 단, 아래와 같은 assert 코드는 자바 실행 시에 java -ea Class 와 같이 옵션을 주어야 예외를 잡을 수 있다
    // -ea : enable-assertion
    public void assertValues(Integer p1, Integer p2) {
        assert p1 != null : "p1 은 널 일 수 없습니다";
        System.out.println("p1 = " + p1);
        assert p2 != null : "p2 은 널 일 수 없습니다";
        System.out.println("p2 = " + p2);
    }

    public static void main(String[] args) {
        FooApp foo = new FooApp();
        Integer p1 = new Integer(10);
        Integer p2 = null;
        foo.assertValues(p1, p2);
    }
}
