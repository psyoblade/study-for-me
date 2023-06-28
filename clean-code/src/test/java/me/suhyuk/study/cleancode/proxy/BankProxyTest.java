package me.suhyuk.study.cleancode.proxy;

import me.suhyuk.study.cleancode.apps.proxy.Bank;
import me.suhyuk.study.cleancode.apps.proxy.BankImpl;
import me.suhyuk.study.cleancode.apps.proxy.BankProxyHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

/* Created by psyoblade on 2023-06-28 */
public class BankProxyTest {

    @Test
    public void testBankProxy() {
        Bank bank = (Bank) Proxy.newProxyInstance(
            Bank.class.getClassLoader(),
            new Class[] { Bank.class },
            new BankProxyHandler(new BankImpl())
        );

        System.out.println("bank = " + bank.getAccounts());
    }
}
