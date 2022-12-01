package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Bank;
import com.nology.synergyapi.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;



//    private List<Bank> banks = new ArrayList<>();
@RestController
    @CrossOrigin(origins  =  "http://localhost:8080")
    public class BankController {
        @GetMapping("/banks")
        public List<Bank> getAllCurrencies() throws IOException {
            return BankService.getBankData();
        }

//@Autowired
     //BankRepository repository;


    //CREATE route
//    @PostMapping("/banks")
//    public Bank createBank(@RequestBody Bank bank) {
//       //Bank.save(bank);
//        return bank;
//    }

//    @GetMapping("/banks")
//    public <Bank> String allBankDetails() {
//   // return "This is a list of Bank details";
//        return ;
//        }




//    @GetMapping("/Bank/{name}")
//    public ResponseEntity<Optional<Bank>> getBankByName(@PathVariable String name) {
//
//        //ResponseEntity
//        // configure the entire response using this
//        // .status() configure the status code we receive
//        return ResponseEntity.status(HttpStatus.OK).body(repository.findByName(name));
//    }
}
