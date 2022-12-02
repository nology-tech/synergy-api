package com.nology.synergyapi.model;

import java.sql.Timestamp;

public class Bank {
    private  String bankName;
    private String createdBy;
    private String bankLogo;
    private Timestamp dateCreated;
    private Long bankId;
    private String sortCode;
    private String iban;

    public Bank(String bankName, String bankLogo, Long bankId, String sortCode, String iban) {
        this.bankName = bankName;
        this.bankLogo = bankLogo;
        this.bankId = bankId;
        this.sortCode = sortCode;
        this.iban = iban;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(String logo) {
        this.bankLogo = logo;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Bank() {

    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", createdBy='" + createdBy + '\'' +
//                ", sortCode='" + sortCode + '\'' +
//                ", iban='" + iban + '\'' +
//                ", bankLogo='" + bankLogo + '\'' +
//                ", dateCreated=" + dateCreated +
                '}';
    }
}
