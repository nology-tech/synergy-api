package com.nology.synergyapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Account {
//    @Column(name = "accountID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;
    private String sortCode;
    private String userID;
    private String currencyID;
    private String IBAN;
    private String accountType;
    private String accountStatus;
    private double accountBalance;
    private Timestamp dateCreated;

    public Account(int accountID, String sortCode, String userID, String currencyID) {
        this.accountID = accountID;
        this.sortCode = sortCode;
        this.userID = userID;
        this.currencyID = currencyID;
        this.dateCreated = new Timestamp(new Date().getTime());
    }
    public Account(int accountID, String sortCode, String userID, String currencyID, String IBAN, String accountType, String accountStatus, double accountBalance, Timestamp dateCreated) {
        this.accountID = accountID;
        this.sortCode = sortCode;
        this.userID = userID;
        this.currencyID = currencyID;
        this.IBAN = IBAN;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Account() {
//        this.sortCode="000"
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", userID='" + userID + '\'' +
                ", currencyID='" + currencyID + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountBalance=" + accountBalance +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
