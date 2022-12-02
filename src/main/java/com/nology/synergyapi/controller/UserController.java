package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.UserProfile;
import com.nology.synergyapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins  =  "http://localhost:8080")
//@CrossOrigin(origins  =  "http://localhost:3000")

public class UserController {

//    @Autowired
//    SynergyApiRepository repository;

    @GetMapping("/users")
    public List<UserProfile> getAllUsers() throws IOException {
        return UserService.getUserData();
    }

    @GetMapping("/users/{uid}")
    public Optional<UserProfile> getUserByID (@PathVariable Long uid) throws IOException {
        return UserService.getUserByID(uid);
    }


}
