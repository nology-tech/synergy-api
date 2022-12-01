package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Bank;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
public class BankController {
    private ArrayList<Bank> banks = new ArrayList<>();

    //CREATE route
    @PostMapping("/banks")
    public String createBank(@RequestBody Bank bank) {
        banks.add(bank);
        return "Bank added";
    }

//    @GetMapping("/Bank")
//    public String bankDetails() {
//        return "Below are the Bank Details!";
//    }
//
//    @GetMapping("/Bank/{name}")
//    public ResponseEntity<Optional<Bank>> getBankByName(@PathVariable String name) {
//        return greetings.stream()
//                .filter(greeting -> greeting.getId() == parseInt(id))
//                .findFirst()
//                .orElse(null);

        //ResponseEntity
        // configure the entire response using this
        // .status() configure the status code we receive
        //return ResponseEntity.status(HttpStatus.OK).body(repository.findByName(name));
    //}
}
