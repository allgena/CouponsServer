package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.bean.Company;

import java.util.List;

public class CompanyDto {

    private long companyId;
    private String companyName;

    private String phoneNumber;
    private String address;

    List<CouponDto> coupons;
    private Integer numberOfPurchases;

    public CompanyDto(long companyId, String companyName, String phoneNumber, String address){
        this.companyId = companyId;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CompanyDto(long companyId, String companyName, List<CouponDto> coupons, int numberOfPurchases) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.coupons = coupons;
        this.numberOfPurchases = numberOfPurchases;
    }

    public CompanyDto(Company company) {
        this.companyId = company.getId();
        this.companyName = company.getCompanyName();
        this.phoneNumber = company.getPhoneNumber();
        this.address = company.getAddress();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
