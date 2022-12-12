package com.nology.synergyapi.model;

import java.sql.Timestamp;

public class Bank {
    private  String bankName;
    private String bankLogo;
    private Timestamp dateCreated;
    private String sortCode;


    public Bank(String bankName, String bankLogo, String sortCode) {
        this.bankName = bankName;
        this.bankLogo = bankLogo;
        this.sortCode = sortCode;

    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(String logo) {
        this.bankLogo = logo;
    }

    public Bank() {

    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "sortCode=" + sortCode +'\'' +
                "bankName='" + bankName + '\'' +
                ", bankLogo='" + bankLogo + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
