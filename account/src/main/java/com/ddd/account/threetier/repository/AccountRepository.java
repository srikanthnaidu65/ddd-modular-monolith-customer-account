package com.ddd.account.threetier.repository;

import com.ddd.account.domain.Account;
import com.ddd.account.domain.AccountId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author srikanth
 * @since 04/02/2023
 * <p>
 * Account Repository or Data Access Layer
 * Using in-memory map instead of db for demo
 */
@Repository
public class AccountRepository {

    private Map<AccountId, Account> accountMap = new HashMap<>();

    public Account save(Account account) {
        System.out.println("in Repository account = " + account);
        accountMap.put(account.getAccountId(), account);
        return account;
    }

    public Account find(AccountId accountId) {
        return accountMap.get(accountId);
    }
}
