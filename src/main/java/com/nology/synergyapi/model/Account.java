package com.nology.synergyapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "accountIdr", nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String accountId;
    private String userId;
    private String sortCode;
    private String accountNumber; // do we need both accountId and accountNumber
    private String accountName;
    private double accountFunds;
    private Timestamp dateCreated;

    public Account(String accountId, String userId, String sortCode, String accountNumber) {
        this.accountId = accountId;
        this.userId = userId;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountFunds() {
        return accountFunds;
    }

    public void setAccountFunds(double accountFunds) {
        this.accountFunds = accountFunds;
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
                "accountId=" + accountId +
                ", userId='" + userId + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountFunds=" + accountFunds +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
