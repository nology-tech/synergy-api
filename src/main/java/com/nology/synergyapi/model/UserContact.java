package com.nology.synergyapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "userContactId", nullable = false)

    private Long userContactId;
    private Long userID;
    private Long contactId;

    public UserContact() {
    }

    public UserContact(Long userID, List<Long> contactIds) {
        this.userID = userID;
        this.contactId = contactId;
    }

    public Long getUserContactId() {
        return userContactId;
    }

    public void setUserContactId(Long userContactId) {
        this.userContactId = userContactId;
    }

    public Long getuserID() {
        return userID;
    }

    public void setuserID(Long userID) {
        this.userID = userID;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "UserContacts{" +
                "userContactId=" + userContactId +
                ", userID=" + userID +
                ", contactId=" + contactId +
                '}';
    }
}
