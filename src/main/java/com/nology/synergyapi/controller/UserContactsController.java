package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.UserContact;
import com.nology.synergyapi.model.UserContactBank;
import com.nology.synergyapi.repository.UserContactsRepository;
import com.nology.synergyapi.repository.UserRepository;
import com.nology.synergyapi.service.UserContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins  = {"http://localhost:3000"})
//@Entity
//@Table(name = "ARTICLES")
public class UserContactsController {
    @Autowired
    UserContactsService userContactsService;
    @Autowired
    UserContactsRepository userContactsRepo;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/userContacts")
    public ResponseEntity <List<UserContact>> getAllUserContacts() throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userContactsRepo.findAll());
    }
//    ADD COMMENT HERE!
//    @GetMapping("/userContacts/{uid}")
//    public ResponseEntity <List<UserContact>> getUserContactsByID (@PathVariable Long uid) throws IOException {
//        return ResponseEntity.status(HttpStatus.OK).body(userContactsRepo.findAll().stream().filter(userContact->userContact.getUserID().equals(uid)).toList());
//    }

    @GetMapping("/contacts/{userId}")
    public  ResponseEntity <List<UserContactBank>> getContactsByUserID (@PathVariable Long userId) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userContactsService.getUserContactsWithBank(userId));
    }

@Transactional
    @DeleteMapping("/deleteUserContact/{userID}/{contactID}")
    public String deleteUserContact(@PathVariable Long userID, @PathVariable Long contactID){

//        userContactsService.deleteUser(contactID);
        userContactsRepo.delete(userContactsService.deleteUserContact(userID, contactID));
        return "Users with id: "+ contactID + " deleted";
    }

}