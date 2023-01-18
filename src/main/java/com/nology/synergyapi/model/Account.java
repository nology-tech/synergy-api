package com.nology.synergyapi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountID", nullable = false)
    private long accountID;
    private String sortCode;
    private String currencyID;
    private String IBAN;
    private String accountType;
    private String accountStatus;
    private double accountBalance;
    private Timestamp dateCreated;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;


    @OneToMany (cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Transaction> transactions= new ArrayList<>();


    public Account(long accountID, String sortCode, User user, String currencyID) {
        this.accountID = accountID;
        this.sortCode = sortCode;
        this.user = user;
        this.currencyID = currencyID;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Account(long accountID, String sortCode, String currencyID, String IBAN, String accountType, String accountStatus, double accountBalance, Timestamp dateCreated, User user, List<Transaction> transactions) {
        this.accountID = accountID;
        this.sortCode = sortCode;
        this.currencyID = currencyID;
        this.IBAN = IBAN;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.dateCreated = dateCreated;
        this.user = user;
        this.transactions = transactions;
//        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Account() {
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Account(String sortCode, String currencyID, String accountType, User user) {
        this.sortCode = sortCode;
        this.currencyID = currencyID;
        this.accountType = accountType;
        this.user = user;
        this.accountBalance = 10000;
        this.accountStatus = "Active";
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
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
                ", userID='" + user.getuserID() + '\'' +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}