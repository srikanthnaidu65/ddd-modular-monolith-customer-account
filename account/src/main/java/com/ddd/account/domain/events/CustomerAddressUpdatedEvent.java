package com.ddd.account.domain.events;

import com.ddd.account.domain.Address;

import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class CustomerAddressUpdatedEvent implements DomainEvent {
    private UUID customerId;
    private Address address;

    public CustomerAddressUpdatedEvent(UUID customerId, Address address) {
        this.customerId = customerId;
        this.address = address;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public Address getAddress() {
        return address;
    }
}
