package com.nology.synergyapi.model;

import java.sql.Timestamp;

public class Bank {
    private  String bankName;
    private String createdBy;
//    private String logo;
//    private Timestamp dateCreated;

    public Bank(String bankName, String createdBy) {
        this.bankName = bankName;
        this.createdBy = createdBy;
//        this.logo = logo;
//        this.dateCreated = dateCreated;
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

//    public String getLogo() {
//        return logo;
//    }

//    public void setLogo(String logo) {
//        this.logo = logo;
//    }

//    public Timestamp getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Timestamp dateCreated) {
//        this.dateCreated = dateCreated;
//    }


    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", createdBy='" + createdBy + '\'' +
//                ", logo='" + logo + '\'' +
//                ", dateCreated=" + dateCreated +
                '}';
    }
}
