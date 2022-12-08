package com.nology.synergyapi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Account {
    //    @Column(name = "accountID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sortCode;
    private String userID;
    private String currencyID;
    private String IBAN;
    private String accountType;
    private String accountStatus;
    private double accountBalance;
    private Timestamp dateCreated;

    //shows relationship between account and a transaction
    //an account have many transaction
    @OneToMany (cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Transaction> transactions= new ArrayList<>();

    public Account(int id, String sortCode, String userID, String currencyID) {
        this.id = id;
        this.sortCode = sortCode;
        this.userID = userID;
        this.currencyID = currencyID;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Account(int id, String sortCode, String userID, String currencyID, String IBAN, String accountType, String accountStatus, double accountBalance, Timestamp dateCreated) {
        this.id = id;
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
//        this.sortCode="000";
//        this.userID="1000000";
//        this.currencyID="USD";
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "accountID='" + id + '\'' +
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}