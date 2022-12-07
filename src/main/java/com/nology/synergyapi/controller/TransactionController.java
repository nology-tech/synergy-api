package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.repository.TransactionRepository;
import com.nology.synergyapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class TransactionController {
    @Autowired
    private  TransactionService transactionService;



    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() throws IOException {
        return transactionService.getTransactionData();
    }

    @GetMapping("/transactions/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable String userId) throws IOException {
        return transactionService.getTransactionByUserId(userId);
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestParam Transaction transaction ) throws IOException {

        return transactionService.createTransaction(transaction);
    }

}

