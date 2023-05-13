package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.bean.Purchase;

public class PurchaseDto {
    private long id;
    private long customerId;
    private String customerName;
    private String couponName;
    private long couponId;
    private String companyName;

    private Integer amountOfPurchased;

    public PurchaseDto(long customerId, String customerName, Integer amountOfPurchased, String couponName, String companyName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.couponName = couponName;
        this.companyName = companyName;
        this.amountOfPurchased = amountOfPurchased;
    }

    public PurchaseDto(Purchase purchase) {
        this.id = purchase.getId();
        if (purchase.getCustomer() != null) {
            this.customerId = purchase.getCustomer().getId();
            this.customerName = purchase.getCustomer().getName();
        }
        this.amountOfPurchased = purchase.getAmountOfPurchased();
        if (purchase.getCoupon()!=null) {
            this.couponId = purchase.getCoupon().getId();
            this.couponName = purchase.getCoupon().getCouponName();
            this.companyName = purchase.getCoupon().getCompany().getCompanyName();
        }
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


    @Override
    public String toString() {
        return "PurchasesDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", couponName='" + couponName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAmountOfPurchased() {
        return amountOfPurchased;
    }

    public void setAmountOfPurchased(Integer amountOfPurchased) {
        this.amountOfPurchased = amountOfPurchased;
    }
}
