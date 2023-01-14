package com.genadi.MyCouponsServer.dto;

public class CustomersDto {

    private long customerId;
    private String customerName;
    private String couponName;
    private String companyName;
    private int amountOfPurchases;

    public CustomersDto(long customerId, String customerName, String couponName, String companyName, int amountOfPurchases) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.couponName = couponName;
        this.companyName = companyName;
        this.amountOfPurchases = amountOfPurchases;
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

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getAmountOfPurchases() {
        return amountOfPurchases;
    }

    public void setAmountOfPurchases(int amountOfPurchases) {
        this.amountOfPurchases = amountOfPurchases;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", couponName='" + couponName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", amountOfPurchases=" + amountOfPurchases +
                '}';
    }
}
