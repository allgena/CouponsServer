package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.bean.Coupon;

import java.util.List;

public class CompanyDto {

    private long companyId;
    private String companyName;
    private List<Coupon> coupons;
    private int numberPurchases;

    public CompanyDto(long companyId, String companyName){
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public CompanyDto(long companyId, String companyName, List<Coupon> coupons, int numberPurchases) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.coupons = coupons;
        this.numberPurchases = numberPurchases;
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

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public int getNumberPurchases() {
        return numberPurchases;
    }

    public void setNumberPurchases(int numberPurchases) {
        this.numberPurchases = numberPurchases;
    }

    @Override
    public String toString() {
        return "CompaniesDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +

                '}';
    }
}
