package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.UserAccount;
import com.nology.synergyapi.repository.UserRepository;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins  = "${frontend.url}")
//@Entity
//@Table(name = "ARTICLES")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity <List<User>> getAllUsers() throws IOException {
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

    @GetMapping("/userbyemail")
    public ResponseEntity <UserAccount> getUserByEmail (@RequestParam String email) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserAccountByEmail(email,userRepo.findAll()));
    }

    @PostMapping("/users")
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount contact){
        UserAccount userAccount = userService.createUserAndAccount(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAccount);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<UserAccount> createUserAndContact(@PathVariable Long id, @RequestBody UserAccount contact){
        UserAccount userAccount = userService.createUserAndAccount(contact);
        userService.createUserContact(id, userAccount.getUserID());
        return ResponseEntity.status(HttpStatus.CREATED).body(userAccount);
    }

    @PostMapping("/users/{id}/{contactId}")
    public ResponseEntity<String> createUserContact(@PathVariable Long id, @PathVariable Long contactId){
        String response = userService.createUserContact(id, contactId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/users/{id}/{contactId}")
    public ResponseEntity<String> deleteUserContact(@PathVariable Long id, @PathVariable Long contactId){
        String response = userService.deleteUserContact(id, contactId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @PostMapping("/users/{id}")
//    public ResponseEntity<User> createUserById(@RequestBody User contact){
//        userRepo.save(contact);
//        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
//    }

    //Delete a greeting
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepo.delete(userRepo.findByUserID(id));
        return "Users with id: "+ id + " deleted";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User newContact){
        User curContact = userRepo.findByUserID(id);
        if(newContact.getuserID()!=null){
            curContact.setuserID(newContact.getuserID());
        }
        if(newContact.getFirstName()!=null){
            curContact.setFirstName(newContact.getFirstName());
        }
        if(newContact.getLastName()!=null){
            curContact.setLastName(newContact.getLastName());
        }
        if(newContact.getEmail()!=null){
            curContact.setEmail(newContact.getEmail());
        }
        if(newContact.getAddress_houseNum() != null){
            curContact.setAddress_houseNum(newContact.getAddress_houseNum());
        }
        if(newContact.getAddress_streetName()!=null){
            curContact.setAddress_streetName(newContact.getAddress_streetName());
        }
        if(newContact.getAddress_city() != null){
            curContact.setAddress_city(newContact.getAddress_city());
        }
        if(newContact.getAddress_state()!=null){
            curContact.setAddress_state(newContact.getAddress_state());
        }
        if(newContact.getAddress_postCode()!= null){
            curContact.setAddress_postCode(newContact.getAddress_postCode());
        }
        if(newContact.getContactFlag()!=null){
            curContact.setContactFlag(newContact.getContactFlag());
        }

        userRepo.save(curContact);
        return "Updated Contact : " + curContact;
    }

}