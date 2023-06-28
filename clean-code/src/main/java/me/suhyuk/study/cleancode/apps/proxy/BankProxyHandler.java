package me.suhyuk.study.cleancode.apps.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* Created by psyoblade on 2023-06-28 */
public class BankProxyHandler implements InvocationHandler {
    private Bank bank;

    public BankProxyHandler(Bank bank) {
        this.bank = bank;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("getAccounts")) {
            bank.setAccounts(getAccountsFromDatabase());
            return bank.getAccounts();
        } else if (methodName.equals("setAccounts")) {
            bank.setAccounts((Collection<Account>) args[0]);
            setAccountsToDatabase(bank.getAccounts());
        } else {
            throw new Exception("Bank proxy handler only support getAccounts and setAccounts");
        }
        return null;
    }

    protected List<Account> getAccountsFromDatabase() {
        Account account = new Account("psyoblade", "suhyuk");
        return Arrays.asList(account);
    }

    protected void setAccountsToDatabase(Collection<Account> accounts) {
        for (Account account : accounts) {
            System.out.println("account = " + account);
        }
    }

}
