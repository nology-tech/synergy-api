package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AccountController {

    @Autowired
    AccountRepository repository;


    @GetMapping("/account/{id}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
    }

    // INDEX route (GET ALL)
    @GetMapping  ("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts () {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

//    // CREATE route
    @PostMapping("/accounts")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        account.setDateCreated(timestamp);
        repository.save(account);
//        id++;
        return ResponseEntity.status(HttpStatus.OK).body(account + " added");
    }
}
