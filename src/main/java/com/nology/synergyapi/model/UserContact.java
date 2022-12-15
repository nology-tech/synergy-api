package com.nology.synergyapi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

//@Entity
public class UserContact {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "userContactId", nullable = false)
    private Long userContactId;

//    @EmbeddedId
//    private UserContactKey userContactId;
//    = new UserContactKey();

//    @ManyToOne
//    @MapsId("userID")
//    @JoinColumn(name = "userID")
//    private User user;
//
//    @ManyToOne
//    @MapsId("contactID")
//    @JoinColumn(name = "contactID")
//    private User user2;
//
    private Date createDateTime;
//
//
    public UserContact() {
    }
//
////    @ManyToOne
////    @JoinColumn(name="contactId")
////    @Column(insertable=false, updatable=false)'
////    private User user;
//
//    public UserContact(Long userID, Long contactID) {
//        this.userContactId = new UserContactKey(userID, contactID);
//        this.createDateTime = new Timestamp(new Date().getTime());
//    }
//
//    public UserContact(User user, User user2) {
//        this.user = user;
//        this.user2 = user2;
//    }
//
////    public UserContact(Long userContactId, User user, User user2) {
////        this.userContactId = userContactId;
////        this.user = user;
////        this.user2 = user2;
////    }
////
////    public Long getUserContactId() {
////        return userContactId;
////    }
////
////    public void setUserContactId(Long userContactId) {
////        this.userContactId = userContactId;
////    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public User getUser2() {
//        return user2;
//    }
//
//    public void setUser2(User user2) {
//        this.user2 = user2;
//    }
//
//    @Override
//    public String toString() {
//        return "UserContact{" +
//                "userContactId=" + userContactId +
//                ", user=" + user +
//                ", user2=" + user2 +
//                '}';
//    }
}
