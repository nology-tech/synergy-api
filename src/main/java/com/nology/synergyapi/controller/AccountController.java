package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    AccountRepository repository;

    @GetMapping("/account/{id}")
    public ResponseEntity<Optional<Account>> getGreetingById(@PathVariable String id) {
        // what made up my response
        // status code
        // body - our actual greeting()
        // headers - additional information regarding the request and response

        // ResponseEntity
        // we can configure our entire response using this
        // .status() configure the status code we receive
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
    }


}
