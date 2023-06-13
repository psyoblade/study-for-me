package me.suhyuk.study.cleancode;

import me.suhyuk.study.cleancode.apps.FooApp;
import org.junit.Test;

/* Created by psyoblade on 2023-06-14 */
public class Foo {

    @Test(expected = AssertionError.class)
    public void testAssertion() {
        FooApp foo = new FooApp();
        Integer p1 = new Integer(10);
        Integer p2 = null;
        foo.assertValues(p1, p2);
    }
}
