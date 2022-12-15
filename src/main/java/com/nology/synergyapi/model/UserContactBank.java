package com.nology.synergyapi.model;

public class UserContactBank {
    private String firstName;
    private String lastName;
    private String bankName;
    private String bankIcon;
    private String sortCode;
    private String IBAN;
    private long account;
    private String account_currency;
    private String accountType;
    private long contactUserId;

    public UserContactBank(String firstName, String lastName, String bankName, String bankIcon, String sortCode, String IBAN, long account, String account_currency, String accountType, long contactUserId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankName = bankName;
        this.bankIcon = bankIcon;
        this.sortCode = sortCode;
        this.IBAN = IBAN;
        this.account = account;
        this.account_currency = account_currency;
        this.accountType = accountType;
        this.contactUserId = contactUserId;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankIcon() {
        return bankIcon;
    }

    public void setBankIcon(String bankIcon) {
        this.bankIcon = bankIcon;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public String getAccount_currency() {
        return account_currency;
    }

    public void setAccount_currency(String account_currency) {
        this.account_currency = account_currency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getContactUserId() {return contactUserId;  }

    public void setContactUserId(long contactUserId) {this.contactUserId = contactUserId; }

    @Override
    public String toString() {
        return "UserContactBank{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankIcon='" + bankIcon + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", account=" + account +
                ", account_currency='" + account_currency + '\'' +
                ", accountType='" + accountType + '\'' +
                ", contactUserId='" + contactUserId + '\'' +
                '}';
    }
}
