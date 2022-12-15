package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.TransactionRepository;
import com.nology.synergyapi.repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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
        Account payeeAccount = accountRepository.findByAccountID(((Integer)rawTransaction.get("payeeAccountId")).longValue());
        Account recipientAccount = accountRepository.findByAccountID(((Integer)rawTransaction.get("recipientAccountId")).longValue());
        Transaction transaction = new Transaction();
        transaction.setPayeeAccount(payeeAccount);
        transaction.setRecipientAccount(recipientAccount);
        transaction.setPayeeAmount(((Integer) rawTransaction.get("payeeAmount")).doubleValue());
        transaction.setRecipientAmount(((Double)  rawTransaction.get("recipientAmount")).doubleValue());
        transaction.setExchangeRate((Double) rawTransaction.get("txnExchangeRate"));
        //transaction.setPayeeFees(((Integer) rawTransaction.get("payeeFees")).doubleValue());
        transaction.setPayeeFees(0.00);
        transaction.setPayeeTotalAmountCharged(((Integer) rawTransaction.get("payeeTotalAmountCharged")).doubleValue());
        Date date = new Timestamp(new Date().getTime());
        transaction.setDateCreated(date);
        transactionRepository.save(transaction);
        payeeAccount.setAccountBalance(payeeAccount.getAccountBalance()-((Integer) rawTransaction.get("payeeAmount")).doubleValue());
        accountRepository.save(payeeAccount);
        return transaction;
    }
}
