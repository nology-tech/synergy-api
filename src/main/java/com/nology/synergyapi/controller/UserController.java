package com.nology.synergyapi.controller;

import com.nology.synergyapi.UserProfileRepository;
import com.nology.synergyapi.model.UserProfile;
import com.nology.synergyapi.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins  =  "http://localhost:8080")
//@CrossOrigin(origins  =  "http://localhost:3000")
//@Entity
//@Table(name = "ARTICLES")
public class UserController {

    @Autowired
    UserProfileRepository userProfileRepo;

    @GetMapping("/users")
    public ResponseEntity <List<UserProfile>> getAllUsers() throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userProfileRepo.findAll());
    }

    @GetMapping("/users/{uid}")
    public ResponseEntity <String> getUserByID (@PathVariable Long uid) throws IOException {

        try{
            return ResponseEntity.status(HttpStatus.OK).body(userProfileRepo.findByUid(uid).toString());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " + uid +" Doesn't exist");
        }
    }

    @PostMapping("/createContact")
    public ResponseEntity<String> createUser(@RequestBody UserProfile contact){
        userProfileRepo.save(contact);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(contact.toString()+ " added");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.toString());
        }
    }

    //Delete a greeting
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        userProfileRepo.delete(userProfileRepo.findByUid(id));
        return "Users with id: "+ id + " deleted";
    }
}
