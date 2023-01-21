package com.nology.synergyapi.model;

import java.util.Date;

public class UserAccount {

    private Long userID;
    private Long accountID;
    private String firstName;
    private String lastName;
    private String email;
    private String address_houseNum;
    private String address_streetName;
    private String address_city;
    private String address_state;
    private String address_postCode;
    private Boolean isContactFlag;
    private Date createDateTime;
    private String accountType;
    private String sortCode;
    private String currencyID;
    private double accountBalance;

    public UserAccount(Long userID, Long accountID, String firstName, String lastName, String email, String address_houseNum, String address_streetName, String address_city, String address_state, String address_postCode, Boolean isContactFlag, Date createDateTime, String accountType, String sortCode, String currencyID) {
        this.userID = userID;
        this.accountID= accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address_houseNum = address_houseNum;
        this.address_streetName = address_streetName;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_postCode = address_postCode;
        this.isContactFlag = isContactFlag;
        this.createDateTime = createDateTime;
        this.accountType = accountType;
        this.sortCode = sortCode;
        this.currencyID = currencyID;
        }

    public UserAccount(Long userID, Long accountID, String firstName, String lastName, String email, String accountType, String sortCode, String currencyID, double accountBalance) {
        this.userID = userID;
        this.accountID= accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accountType = accountType;
        this.sortCode = sortCode;
        this.currencyID = currencyID;
        this.accountBalance = accountBalance;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress_houseNum() {
        return address_houseNum;
    }

    public void setAddress_houseNum(String address_houseNum) {
        this.address_houseNum = address_houseNum;
    }

    public String getAddress_streetName() {
        return address_streetName;
    }

    public void setAddress_streetName(String address_streetName) {
        this.address_streetName = address_streetName;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getAddress_postCode() {
        return address_postCode;
    }

    public void setAddress_postCode(String address_postCode) {
        this.address_postCode = address_postCode;
    }

    public Boolean getContactFlag() {
        return isContactFlag;
    }

    public void setContactFlag(Boolean contactFlag) {
        isContactFlag = contactFlag;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userID=" + userID +
                ", accountID=" + accountID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address_houseNum='" + address_houseNum + '\'' +
                ", address_streetName='" + address_streetName + '\'' +
                ", address_city='" + address_city + '\'' +
                ", address_state='" + address_state + '\'' +
                ", address_postCode='" + address_postCode + '\'' +
                ", isContactFlag=" + isContactFlag +
                ", createDateTime=" + createDateTime +
                ", accountType='" + accountType + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", currencyID='" + currencyID + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                '}';
    }
}
