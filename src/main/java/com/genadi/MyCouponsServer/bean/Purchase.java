package com.genadi.MyCouponsServer.bean;

import javax.persistence.*;

@Entity
@Table(name = "Purchases")
public class Purchase {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    @Column
    private int amountOfPurchased;

    public Purchase(){}

    public Purchase(Customer customer, Coupon coupon, int amountOfPurchased) {
        this.customer = customer;
        this.coupon = coupon;
        this.amountOfPurchased = amountOfPurchased;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                ", customer=" + customer +
                ", coupon=" + coupon +
                ", amountOfPurchased=" + amountOfPurchased +
                '}';
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
