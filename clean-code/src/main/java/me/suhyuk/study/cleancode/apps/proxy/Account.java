package me.suhyuk.study.cleancode.apps.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* Created by psyoblade on 2023-06-28 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
    private String accountId;
    private String accountName;
}
