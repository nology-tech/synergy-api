package com.nology.synergyapi.controller;

import com.nology.synergyapi.UserRepository;
import com.nology.synergyapi.model.Users;
import jakarta.persistence.Entity;
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
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    public ResponseEntity <List<Users>> getAllUsers() throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
    }

    @GetMapping("/users/{uid}")
    public ResponseEntity <String> getUserByID (@PathVariable Long uid) throws IOException {

        try{
            return ResponseEntity.status(HttpStatus.OK).body(userRepo.findByUserID(uid).toString());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " + uid +" Doesn't exist");
        }
    }

    @PostMapping("/createContact")
    public ResponseEntity<String> createUser(@RequestBody Users contact){
        userRepo.save(contact);
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
        userRepo.delete(userRepo.findByUserID(id));
        return "Users with id: "+ id + " deleted";
    }

}
