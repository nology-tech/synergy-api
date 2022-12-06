package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.service.TransactionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class TransactionController {
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() throws IOException {
        return TransactionService.getTransactionData();
    }

    @GetMapping("transactions/{userId}")
    public Optional<Transaction> getTransactionsByUser(@PathVariable String userId) throws IOException {
        return TransactionService.getTransactionByUserId(userId);
    }
}

