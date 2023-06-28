package me.suhyuk.study.cleancode.apps.proxy;

import java.util.Collection;

/* Created by psyoblade on 2023-06-28 */
public interface Bank {
    Collection<Account> getAccounts();
    void setAccounts(Collection<Account> accounts);
}
