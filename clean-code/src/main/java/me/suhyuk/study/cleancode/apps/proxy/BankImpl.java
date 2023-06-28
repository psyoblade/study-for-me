package me.suhyuk.study.cleancode.apps.proxy;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* Created by psyoblade on 2023-06-28 */
@ToString
public class BankImpl implements Bank {
    private List<Account> accounts;

    @Override
    public Collection<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void setAccounts(Collection<Account> accounts) {
        this.accounts = new ArrayList<>();
        for (Account account : accounts) {
            this.accounts.add(account);
        }
    }
}
