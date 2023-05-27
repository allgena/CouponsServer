package com.genadi.MyCouponsServer.bean;

import javax.persistence.*;

@Entity
@Table(name = "Customers",indexes = {@Index(name = "uniqueNameIndex", columnList = "name", unique = true)
})
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    private User user;
    @Column
    private String address;
    @Column
    private String phoneNumber;


    public Customer() {

    }

    public Customer(String name, User user, String address, String phoneNumber) {
        this.name = name;
        this.user = user;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", user=" + user +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
