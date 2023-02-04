package com.ddd.account.threetier.controller.resource;

import com.ddd.account.domain.Account;

import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class AccountData {
    private UUID accountId;

    private AddressData addressData;

    public AccountData() {
    }

    public static AccountData from(Account account) {
        AccountData accountData = new AccountData();
        accountData.setAccountId(account.getAccountId().getAccountIdUUID());
        accountData.setAddressData(AddressData.from(account.getAddress()));
        return accountData;
    }

    public AddressData getAddressData() {
        return addressData;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }
}
