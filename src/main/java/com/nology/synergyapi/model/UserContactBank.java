package com.nology.synergyapi.model;

public class UserContactBank {
    private String firstName;
    private String lastName;
    private String bankName;
    private String bankIcon;
    private String sortCode;
    private String IBAN;
    private int account;
    private String account_currency;

    public UserContactBank(String firstName, String lastName, String bankName, String bankIcon, String sortCode, String IBAN, int account, String account_currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankName = bankName;
        this.bankIcon = bankIcon;
        this.sortCode = sortCode;
        this.IBAN = IBAN;
        this.account = account;
        this.account_currency = account_currency;
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

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getAccount_currency() {
        return account_currency;
    }

    public void setAccount_currency(String account_currency) {
        this.account_currency = account_currency;
    }

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
                '}';
    }
}
