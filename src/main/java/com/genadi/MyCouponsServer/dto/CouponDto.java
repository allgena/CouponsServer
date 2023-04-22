package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.enams.CouponCategory;

import java.util.Date;

public class CouponDto {

    private long couponId;
    private String couponName;
    private String companyName;
    private CouponCategory category;
    private String description;
    private float price;
    private Date startDate;
    private Date endDate;

    private Integer numberOfPurchases;

    public CouponDto(long couponId, String couponName, String companyName,  CouponCategory category, String description, float price, Date startDate, Date endDate, int amountOfPurchases) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.companyName = companyName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPurchases =amountOfPurchases;
        this.category = category;
        this.description = description;
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

    public Integer getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(Integer numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
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
                ", amountOfPurchases=" + numberOfPurchases +
                '}';
    }

    public CouponCategory getCategory() {
        return category;
    }

    public void setCategory(CouponCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
