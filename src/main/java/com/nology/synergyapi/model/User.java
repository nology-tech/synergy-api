package com.nology.synergyapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "userID", nullable = false)

    private Long userID;
    private String firstName;
    private String lastName;
    private String email;
    private String address_houseNum;
    private String address_streetName;
    private String address_city;
    private String address_state;
    private String address_postCode;
    private Boolean isContactFlag;
    private Date createDateTime;

    @OneToOne( mappedBy = "user")
    @JsonIgnore
    private Account account;

//    @OneToMany( mappedBy = "user")
//    @JsonIgnore
//    List<UserContact> contacts;
//
//    @OneToMany( mappedBy = "user2")
//    @JsonIgnore
//    List<UserContact> users;

    @ManyToMany
    @JoinTable(name = "usercontact", joinColumns = @JoinColumn(name="userID"), inverseJoinColumns = @JoinColumn(name="contactID"))
    @JsonIgnore
    private Set<User> contacts = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "usercontact", joinColumns = @JoinColumn(name="contactID"), inverseJoinColumns = @JoinColumn(name="userID"))
    @JsonIgnore
    private Set<User> contactOf = new HashSet<>();

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "usercontacts",
//        joinColumns = { @JoinColumn(name = "userID", referencedColumnName = "userID")},
//            inverseJoinColumns = { @JoinColumn(name = "contactUserID", referencedColumnName = "userID")})
//    private User user;

    public User() {
        this.createDateTime= new Timestamp(new Date().getTime());
    }

    public User(Long userID, String firstName, String lastName, String email, String address_houseNum, String address_streetName, String address_city, String address_state, String address_postCode) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address_houseNum = address_houseNum;
        this.address_streetName = address_streetName;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_postCode = address_postCode;
        this.isContactFlag = isContactFlag;
        this.createDateTime = new Timestamp(new Date().getTime());
    }

    public User(String firstName, String lastName, String email, String address_houseNum, String address_streetName, String address_city, String address_state, String address_postCode, Boolean isContactFlag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address_houseNum = address_houseNum;
        this.address_streetName = address_streetName;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_postCode = address_postCode;
        this.isContactFlag = isContactFlag;
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

    public Boolean getContactFlag() {
        return isContactFlag;
    }

    public void setContactFlag(Boolean contactFlag) {
        isContactFlag = contactFlag;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address_houseNum='" + address_houseNum + '\'' +
                ", address_streetName='" + address_streetName + '\'' +
                ", address_city='" + address_city + '\'' +
                ", address_state='" + address_state + '\'' +
                ", address_postCode='" + address_postCode + '\'' +
                ", isContactFlag=" + isContactFlag +
                ", createDateTime=" + createDateTime +
                '}';
    }

    public Long getuserID() {
        return userID;
    }

    public void setuserID(Long userID) {
        this.userID = userID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<User> getContacts() {return contacts;}

    public void setContacts(Set<User> contacts) {
        this.contacts = contacts;
    }
//    public List<UserContact> getContacts() {
//        return contacts;
//    }
}
