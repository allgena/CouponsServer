package com.genadi.MyCouponsServer.dto;

import java.util.List;

public class CompanyDto {

    private long companyId;
    private String companyName;
    List<CouponDto> coupons;
    private Integer numberOfPurchases;

    public CompanyDto(long companyId, String companyName){
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public CompanyDto(long companyId, String companyName, List<CouponDto> coupons, int numberOfPurchases) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.coupons = coupons;
        this.numberOfPurchases = numberOfPurchases;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<CouponDto> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponDto> coupons) {
        this.coupons = coupons;
    }

    public Integer getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(Integer numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    @Override
    public String toString() {
        return "CompaniesDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +

                '}';
    }
}
