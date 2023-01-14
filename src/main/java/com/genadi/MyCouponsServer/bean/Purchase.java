package com.genadi.MyCouponsServer.bean;

import javax.persistence.*;

@Entity
@Table(name = "Purchases")
public class Purchase {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private long customerId;
    @Column
    private long couponId;
    @Column
    private int amountOfPurchased;

    public Purchase(){}

    public Purchase(long id, long customerId, long couponId, int amountOfPurchased) {
        this.id = id;
        this.customerId = customerId;
        this.couponId = couponId;
        this.amountOfPurchased = amountOfPurchased;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public int getAmountOfPurchased() {
        return amountOfPurchased;
    }

    public void setAmountOfPurchased(int amountOfPurchased) {
        this.amountOfPurchased = amountOfPurchased;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", couponId=" + couponId +
                ", amountOfPurchased=" + amountOfPurchased +
                '}';
    }
}
