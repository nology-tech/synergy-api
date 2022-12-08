package com.nology.synergyapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="transferTxn")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name = "tid", nullable = false)

    private Long txnId;
    @OneToOne( fetch = FetchType.LAZY)
    private Account recipientAccount;
    @OneToOne( fetch = FetchType.LAZY)
    private Account payeeAccount;
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

    public Transaction(Long txnId, Account recipientAccount, Account payeeAccount,
                       double payeeAmount, double recipientAmount, double payeeFees,
                       double payeeTotalAmountCharged, Date dateCreated,  double exchangeRate) {

        this.txnId = txnId;
        this.recipientAccount = recipientAccount;
        this.payeeAccount = payeeAccount;
        this.payeeAmount = payeeAmount;
        this.recipientAmount = recipientAmount;
        this.payeeFees = payeeFees;
        this.payeeTotalAmountCharged = payeeTotalAmountCharged;
        this.dateCreated = dateCreated;
        this.exchangeRate = exchangeRate;
    }

    public Account getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(Account recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public Account getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(Account payeeAccount) {
        this.payeeAccount = payeeAccount;
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
