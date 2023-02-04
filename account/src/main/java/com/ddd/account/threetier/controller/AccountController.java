package com.ddd.account.threetier.controller;

import com.ddd.account.domain.Account;
import com.ddd.account.domain.Address;
import com.ddd.account.domain.CustomerId;
import com.ddd.account.threetier.applicationservice.AccountAppService;
import com.ddd.account.threetier.controller.resource.AccountResource;
import com.ddd.account.threetier.controller.viewmodel.AccountRequest;
import com.ddd.account.threetier.controller.viewmodel.AddressRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
@RestController
public class AccountController {

    private final AccountAppService accountAppService;

    public AccountController(AccountAppService accountAppService) {
        this.accountAppService = accountAppService;
    }

    @PostMapping("/accounts")
    public AccountResource create(@RequestBody AccountRequest request) {
        System.out.println("request = " + request);

        Account account = accountAppService.createAccount(
                new Account(new Address(request.getAddressRequest().getCity()),
                        new CustomerId(UUID.fromString(request.getCustomerId()))));

        return AccountResource.from(account);
    }

    @PutMapping("/accounts/{accountId}/address")
    public AccountResource updateAddress(@RequestBody AddressRequest request, @PathVariable String accountId) {
        System.out.println("request = " + request);
        System.out.println("PathVariable = " + accountId);

        Account account = accountAppService.updateAddress(UUID.fromString(accountId), new Address(request.getCity()));

        return AccountResource.from(account);
    }
}
