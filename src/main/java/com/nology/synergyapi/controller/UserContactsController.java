package com.nology.synergyapi.controller;

import com.nology.synergyapi.repository.UserContactsRepository;
import com.nology.synergyapi.model.UserContact;
import com.nology.synergyapi.model.UserContactBank;
import com.nology.synergyapi.service.UserContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    UserContactsRepository userContactsRepo;



//    @GetMapping("/userContacts")
//    public ResponseEntity <List<UserContact>> getAllUserContacts() throws IOException {
//        return ResponseEntity.status(HttpStatus.OK).body(userContactsRepo.findAll());
//    }

//    @GetMapping("/userContacts/{uid}")
//    public ResponseEntity <List<UserContact>> getUserContactsByID (@PathVariable Long uid) throws IOException {
//        return ResponseEntity.status(HttpStatus.OK).body(userContactsRepo.findAll().stream().filter(userContact->userContact.getUserID().equals(uid)).toList());
//    }

    @GetMapping("/contacts/{userId}")
    public  ResponseEntity <List<UserContactBank>> getContactsByUserID (@PathVariable Long userId) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userContactsService.getUserContactsWithBank(userId));
    }

    @PostMapping("/createUserContacts")
    public ResponseEntity<String> createUserContacts(@RequestBody UserContact userContact){
        userContactsRepo.save(userContact);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userContact.toString()+ " added");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.toString());
        }
    }

    @DeleteMapping("/userContacts/{userContactId}")
    public String deleteUserContact(@PathVariable Long userContactId){
        userContactsRepo.delete(userContactsRepo.findByUserContactId(userContactId));
        return "Users with id: "+ userContactId + " deleted";
    }

}
