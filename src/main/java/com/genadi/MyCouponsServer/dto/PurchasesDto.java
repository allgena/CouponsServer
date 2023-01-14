package com.genadi.MyCouponsServer.dto;

public class PurchasesDto {
    private long customerId;
    private String customerName;
    private int amountOfPurchases;
    private String couponName;
    private String companyName;

    public PurchasesDto(long customerId, String customerName, int amountOfPurchases, String couponName, String companyName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.amountOfPurchases = amountOfPurchases;
        this.couponName = couponName;
        this.companyName = companyName;
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

    public int getAmountOfPurchases() {
        return amountOfPurchases;
    }

    public void setAmountOfPurchases(int amountOfPurchases) {
        this.amountOfPurchases = amountOfPurchases;
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


    @Override
    public String toString() {
        return "PurchasesDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", amountOfPurchases=" + amountOfPurchases +
                ", couponName='" + couponName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
