package com.nology.synergyapi.model;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tid", nullable = false)

    private long tid;
    private String transactionTo;
    private String transactionFrom;
    private double transactionAmount;
    private String currency;

    public Transaction(){
        super();
    }

    public Transaction(long tid, String transactionTo, String transactionFrom, double transactionAmount, String currency) {
        this.tid = tid;
        this.transactionTo = transactionTo;
        this.transactionFrom = transactionFrom;
        this.transactionAmount = transactionAmount;
        this.currency = currency;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(String transactionTo) {
        this.transactionTo = transactionTo;
    }

    public String getTransactionFrom() {
        return transactionFrom;
    }

    public void setTransactionFrom(String transactionFrom) {
        this.transactionFrom = transactionFrom;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

// boolean withdraw and deposit  (if the request from me - withdraw, to me - deposit)
}
