package com.nology.synergyapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class UserContactKey implements Serializable {
    @Column(name = "userID")
    Long userID;

    @Column(name="contactID")
    Long contactID;

    public UserContactKey() {
        super();
    }

    public UserContactKey(Long userID, Long contactID) {
        super();
        this.userID = userID;
        this.contactID = contactID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getContactID() {
        return contactID;
    }

    public void setContactID(Long contactID) {
        this.contactID = contactID;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserContactKey that = (UserContactKey) o;
////        System.out.println("equals");
////        System.out.println("userID " + userID);
////        System.out.println("contactId" + contactId);
////
////        System.out.println("That userID " + that.userID);
////        System.out.println("That contactId" + that.contactId);
//        return userID.equals(that.userID) && contactID.equals(that.contactID);
//    }
//
//    @Override
//    public int hashCode() {
//        System.out.println("Hashcode");
////        System.out.println(Objects.hash(userID, contactId));
//        return Objects.hash(userID, contactID);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserContactKey that)) return false;
        return getUserID().equals(that.getUserID()) && getContactID().equals(that.getContactID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getContactID());
    }
}