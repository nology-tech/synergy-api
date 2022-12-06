package com.nology.synergyapi.controller;

import com.nology.synergyapi.UserContactsRepository;
import com.nology.synergyapi.model.UserContacts;
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
    UserContactsRepository userContactsRepo;

    @GetMapping("/userContacts")
    public ResponseEntity <List<UserContacts>> getAllUserContacts() throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userContactsRepo.findAll());
    }

    @GetMapping("/userContacts/{uid}")
    public ResponseEntity <String> getUserContactsByID (@PathVariable Long uid) throws IOException {

        try{
            return ResponseEntity.status(HttpStatus.OK).body(userContactsRepo.findByUserContactId(uid).toString());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " + uid +" Doesn't exist");
        }
    }

    @PostMapping("/createUserContacts")
    public ResponseEntity<String> createUserContacts(@RequestBody UserContacts userContact){
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
