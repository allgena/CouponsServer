package com.genadi.MyCouponsServer.bean;

import javax.persistence.*;

@Entity
@Table(name = "Companies")
public class Company {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String companyName;
    @Column
    private String address;
    @Column
    private String phoneNumber;

    public Company() {
    }

    public Company(long id, String companyName, String address, String phoneNumber) {
        this(companyName, address, phoneNumber);
        this.id = id;
    }

    public Company(String companyName, String address, String phoneNumber) {
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
