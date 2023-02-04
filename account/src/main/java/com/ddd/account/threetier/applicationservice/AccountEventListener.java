package com.ddd.account.threetier.applicationservice;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class AccountEventListener {

    //Subscribes to customer-topic and listens for CustomerAddressChangedEvent.
    public void listen() {
        //Fetches all account from repository matching customerId in CustomerAddressChangedEvent
        //updates address of each account
    }
}
