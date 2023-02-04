package com.ddd.customer.threetier.controller.viewmodel;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class CustomerRequest {
    private AddressRequest addressRequest;

    public CustomerRequest() {
    }

    //needed for spring framework
    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    //needed for spring framework
    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "addressRequest=" + addressRequest +
                '}';
    }
}
