package com.example.nipc26.librarymanagement.model;

import java.io.Serializable;

/**
 * Created by NI PC 26 on 10/21/2016.
 */

public class CreateUserModel implements Serializable{
    private String userName;
    private String password;
    private String userType;
    private String collegeId;
    private String mobileNo;
    private String year;
    private String fullName;
    private String emailId;
    private String dob;
    private String noOfBookIssued;
    private String approved;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNoOfBookIssued() {
        return noOfBookIssued;
    }

    public void setNoOfBookIssued(String noOfBookIssued) {
        this.noOfBookIssued = noOfBookIssued;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "CreateUserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", year='" + year + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dob='" + dob + '\'' +
                ", noOfBookIssued='" + noOfBookIssued + '\'' +
                ", approved='" + approved + '\'' +
                '}';
    }
}
