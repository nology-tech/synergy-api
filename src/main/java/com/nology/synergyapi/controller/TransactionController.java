package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.service.TransactionService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "${frontend.url}")

public class TransactionController {
    @Autowired
    private  TransactionService transactionService;


    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() throws IOException {
        return transactionService.getTransactionData();
    }

    @GetMapping("/transactions/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable Long userId) throws IOException {
        return transactionService.getTransactionByUserId(userId);
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody JSONObject transactionData ) throws IOException {
            return transactionService.createTransaction(transactionData);
    }

}

