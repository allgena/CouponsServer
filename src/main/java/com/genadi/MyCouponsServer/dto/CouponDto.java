package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.bean.Coupon;
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

    private String imageURL;

    public CouponDto(long couponId, String couponName, String companyName,  CouponCategory category, String description, float price, Date startDate, Date endDate, int amountOfPurchases) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.companyName = companyName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPurchases =amountOfPurchases;
        this.category = category;
        this.imageURL= category.getImage();
        this.description = description;
    }
    public CouponDto(Coupon coupon){
        this.couponId = coupon.getId();
        this.couponName = coupon.getCouponName();
        this.companyName = coupon.getCompany().getCompanyName();
        this.price = coupon.getPrice();
        this.startDate = coupon.getStartDate();
        this.endDate = coupon.getEndDate();
        this.category = coupon.getCategory();
        if (coupon.getImageURL() == null || coupon.getImageURL().isEmpty())
            this.imageURL= category.getImage();
        else
            this.imageURL = coupon.getImageURL();
        this.description = coupon.getDescription();
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
