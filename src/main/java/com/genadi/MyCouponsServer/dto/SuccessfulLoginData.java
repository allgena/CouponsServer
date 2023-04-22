package com.genadi.MyCouponsServer.dto;

import com.genadi.MyCouponsServer.enams.UserType;

public class SuccessfulLoginData {
    private long id;
    private String userName;
    private Long companyId;
    private UserType userType;

    public SuccessfulLoginData(long id, String userName, Long companyId, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.companyId = companyId;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
