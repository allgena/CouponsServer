package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.bean.Coupon;

import java.util.List;

public class CompanyDto {

    private long companyId;
    private String companyName;
    private List<Coupon> coupons;


    public CompanyDto(long companyId, String companyName, List<Coupon> coupons) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.coupons = coupons;
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



    @Override
    public String toString() {
        return "CompaniesDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +

                '}';
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}
