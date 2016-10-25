package com.example.nipc26.librarymanagement.model;

/**
 * Created by NI PC 26 on 10/20/2016.
 */

public class UserLoginModel {
    private String userName;
    private String password;
    private String userType;
    private String approved;

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    @Override
    public String toString() {
        return "UserLoginModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", approved='" + approved + '\'' +
                '}';
    }
}
