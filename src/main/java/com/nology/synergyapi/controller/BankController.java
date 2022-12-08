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




@RestController
    @CrossOrigin(origins  =  "http://localhost:3000")
    public class BankController {
    @GetMapping("/banks")
    public List<Bank> getAllBanks() throws IOException {
        return BankService.getBankData();
    }
}


