package com.genadi.MyCouponsServer.dto;

import java.sql.Date;

public class CouponsDto {

    private long couponId;
    private String couponName;
    private String companyName;
    private float price;
    private Date startDate;
    private Date endDate;

    private int amountOfPurchases;


    public CouponsDto(long couponId, String couponName, String companyName,float price,int amountOfPurchases){
        this.couponId = couponId;
        this.couponName = couponName;
        this.companyName = companyName;
        this.price = price;
        this.amountOfPurchases=amountOfPurchases;

    }
    public CouponsDto(long couponId, String couponName, String companyName, float price, Date startDate, Date endDate,int amountOfPurchases) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.companyName = companyName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountOfPurchases=amountOfPurchases;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAmountOfPurchases() {
        return amountOfPurchases;
    }

    public void setAmountOfPurchases(int amountOfPurchases) {
        this.amountOfPurchases = amountOfPurchases;
    }

    @Override
    public String toString() {
        return "CouponsDto{" +
                "couponId=" + couponId +
                ", couponName='" + couponName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amountOfPurchases=" + amountOfPurchases +
                '}';
    }
}
