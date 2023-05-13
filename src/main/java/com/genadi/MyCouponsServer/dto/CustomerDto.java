package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.bean.Customer;

public class CustomerDto {

    private long customerId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private Integer amountOfPurchases;

    public CustomerDto(Customer customer) {
        this.customerId = customer.getId();
        this.address = customer.getAddress();
        this.customerName = customer.getName();
        this.phoneNumber = customer.getPhoneNumber();
    }

    public CustomerDto() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public Integer getAmountOfPurchases() {
        return amountOfPurchases;
    }

    public void setAmountOfPurchases(Integer amountOfPurchases) {
        this.amountOfPurchases = amountOfPurchases;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", amountOfPurchases=" + amountOfPurchases +
                '}';
    }
}
