package com.nology.synergyapi.controller;

import com.nology.synergyapi.BankRepository;
import com.nology.synergyapi.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BankController {
    private List<Bank> banks = new ArrayList<>();


//    @Autowired
     BankRepository repository;


    //CREATE route
    @PostMapping("/banks")
    public Bank createBank(@RequestBody Bank bank) {
        banks.add(bank);
        return bank;
    }

    @GetMapping("/banks")
    public String allBankDetails() {
    return "This is a list of Bank details";
  //       return repository.findAll();
        }

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
