package com.nology.synergyapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserContactKey implements Serializable {
    @Column(name = "userID")
    Long userID;

    @Column(name="contactID")
    Long contactId;
}