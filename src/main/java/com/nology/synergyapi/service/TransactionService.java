package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.TransactionRepository;
import com.nology.synergyapi.repository.UserRepository;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public  List<Transaction> getTransactionData() throws IOException {
        return transactionRepository.findAll();
    }

    public  List<Transaction> getTransactionByUserId(Long userID) throws IOException {
        Account account=accountRepository.findByUserID(userID);
        return account.getTransactions();
    }

    public Transaction createTransaction(JSONObject rawTransaction) {
        Account payeeAccount = accountRepository.findById((long) rawTransaction.get("payeeAccountId")).orElse(null);
        Account recipientAccount = accountRepository.findById((long) rawTransaction.get("recipientAccount")).orElse(null);
        Transaction transaction = new Transaction();
        transaction.setPayeeAccount(payeeAccount);
        transaction.setRecipientAccount(recipientAccount);
        transaction.setPayeeAmount((double) rawTransaction.get("payeeAmount"));
        transaction.setRecipientAmount((double) rawTransaction.get("recipientAmount"));
        transaction.setExchangeRate((double) rawTransaction.get("exchangeRate"));
        transaction.setPayeeFees((double) rawTransaction.get("payeeFees"));
        transaction.setPayeeTotalAmountCharged((double) rawTransaction.get("payeeTotalAmountCharged"));
        transaction.setDateCreated(new Timestamp(new Date().getTime()));
        return null;
    }
}
