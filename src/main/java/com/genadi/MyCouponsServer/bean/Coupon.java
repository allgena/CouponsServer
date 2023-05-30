package com.genadi.MyCouponsServer.bean;


import com.genadi.MyCouponsServer.enams.CouponCategory;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Coupons")
public class Coupon {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String couponName;
    @Enumerated(EnumType.STRING)
    @Column
    private CouponCategory category;
    @Column
    private float price;
    @Column
    private String description;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(length = 1000)
    private String imageURL;

    public Coupon() {
    }

    public Coupon(long id, String couponName, CouponCategory category,float price, String description, Date startDate, Date endDate,  Company company) {
        this(couponName, category,price, description, startDate, endDate, company);
        this.id = id;
    }

    public Coupon(String couponName, CouponCategory category, float price, String description, Date startDate, Date endDate,  Company company) {
        this.couponName = couponName;
        this.category=category;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public CouponCategory getCategory() {
        return category;
    }

    public void setCategory(CouponCategory category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", couponName='" + couponName + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", company=" + company +
                '}';
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
