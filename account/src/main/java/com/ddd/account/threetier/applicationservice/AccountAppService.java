package com.ddd.account.threetier.applicationservice;

import com.ddd.account.domain.Account;
import com.ddd.account.domain.Address;
import com.ddd.account.threetier.repository.AccountRepository;
import com.ddd.account.domain.AccountId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
@Service
public class AccountAppService {

    private AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;

    public AccountAppService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //@Transactional
    public Account createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        restTemplate.put("http://localhost:8083/customers/" + account.getCustomerIdAsString() + "/accounts/" + account.getAccountIdAsString(),
                null, new HashMap<>());
        return savedAccount;
    }

    //@Transactional
    public Account updateAddress(UUID accountId, Address address) {
        Account account = accountRepository.find(new AccountId(accountId));
        account.updateAddress(address);
        return accountRepository.save(account);
    }
}
