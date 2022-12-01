package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.model.UserProfile;
import com.nology.synergyapi.service.CurrencyService;
import com.nology.synergyapi.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins  =  "http://localhost:8080")
public class UserController {
    @GetMapping("/users")
    public List<UserProfile> getAllUsers() throws IOException {
        return UserService.getUserData();
    }

}
