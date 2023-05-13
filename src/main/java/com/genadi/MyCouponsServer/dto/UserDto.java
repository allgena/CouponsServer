package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.enams.UserType;

public class UserDto {
    private long userId;
    private String userName;
    private UserType userType;
    private String phoneNumber;
    private String companyName;

    public UserDto(long userId, String userName, UserType userType, String phoneNumber, String companyName) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
    }

    public UserDto() {
    }

    public UserDto(User user) {
        this.userId = user.getId();
        this.phoneNumber = user.getPhoneNumber();
        this.userName = user.getUserName();
        this.userType= user.getUserType();
        if (user.getCompany() != null)
            this.companyName = user.getCompany().getCompanyName();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
