package com.nology.synergyapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name = "tid", nullable = false)

    private String txnId;
    private String recipientAccountId;
    private String payeeAccountId;
    private double payeeAmount;
    private double recipientAmount;
    private double payeeFees;
    private double payeeTotalAmountCharged;
    private Date dateCreated;
    private String recipientCurrency;
    private String payeeCurrency;
    private double exchangeRate;

    public Transaction(){
        super();
    }

    public Transaction(String txnId, String recipientAccountId, String payeeAccountId,
                       double payeeAmount, double recipientAmount, double payeeFees,
                       double payeeTotalAmountCharged, Date dateCreated, String recipientCurrency,
                       String payeeCurrency, double exchangeRate) {

        this.txnId = txnId;
        this.recipientAccountId = recipientAccountId;
        this.payeeAccountId = payeeAccountId;
        this.payeeAmount = payeeAmount;
        this.recipientAmount = recipientAmount;
        this.payeeFees = payeeFees;
        this.payeeTotalAmountCharged = payeeTotalAmountCharged;
        this.dateCreated = dateCreated;
        this.recipientCurrency = recipientCurrency;
        this.payeeCurrency = payeeCurrency;
        this.exchangeRate = exchangeRate;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(String recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }

    public String getPayeeAccountId() {
        return payeeAccountId;
    }

    public void setPayeeAccountId(String payeeAccountId) {
        this.payeeAccountId = payeeAccountId;
    }

    public double getPayeeAmount() {
        return payeeAmount;
    }

    public void setPayeeAmount(double payeeAmount) {
        this.payeeAmount = payeeAmount;
    }

    public double getRecipientAmount() {
        return recipientAmount;
    }

    public void setRecipientAmount(double recipientAmount) {
        this.recipientAmount = recipientAmount;
    }

    public double getPayeeFees() {
        return payeeFees;
    }

    public void setPayeeFees(double payeeFees) {
        this.payeeFees = payeeFees;
    }

    public double getPayeeTotalAmountCharged() {
        return payeeTotalAmountCharged;
    }

    public void setPayeeTotalAmountCharged(double payeeTotalAmountCharged) {
        this.payeeTotalAmountCharged = payeeTotalAmountCharged;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getRecipientCurrency() {
        return recipientCurrency;
    }

    public void setRecipientCurrency(String recipientCurrency) {
        this.recipientCurrency = recipientCurrency;
    }

    public String getPayeeCurrency() {
        return payeeCurrency;
    }

    public void setPayeeCurrency(String payeeCurrency) {
        this.payeeCurrency = payeeCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
