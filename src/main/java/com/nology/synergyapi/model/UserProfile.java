package com.nology.synergyapi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

import java.util.Date;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "uid", nullable = false)

    private Long uid;
    private String firstName;
    private String lastName;
    private String email;
    private String address_houseNum;
    private String address_streetName;
    private String address_city;
    private String address_state;
    private String address_postCode;
    private String user_type;
    private Date createDateTime;

    public UserProfile() {
        super();
    }

    public UserProfile(Long uid, String firstName, String lastName, String email, String address_houseNum, String address_streetName, String address_city, String address_state, String address_postCode, String user_type) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address_houseNum = address_houseNum;
        this.address_streetName = address_streetName;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_postCode = address_postCode;
        this.user_type = user_type;
        this.createDateTime = new Timestamp(new Date().getTime());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress_houseNum() {
        return address_houseNum;
    }

    public void setAddress_houseNum(String address_houseNum) {
        this.address_houseNum = address_houseNum;
    }

    public String getAddress_streetName() {
        return address_streetName;
    }

    public void setAddress_streetName(String address_streetName) {
        this.address_streetName = address_streetName;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getAddress_postCode() {
        return address_postCode;
    }

    public void setAddress_postCode(String address_postCode) {
        this.address_postCode = address_postCode;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address_houseNum='" + address_houseNum + '\'' +
                ", address_streetName='" + address_streetName + '\'' +
                ", address_city='" + address_city + '\'' +
                ", address_state='" + address_state + '\'' +
                ", address_postCode='" + address_postCode + '\'' +
                ", user_type='" + user_type + '\'' +
                ", createDateTime=" + createDateTime +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
