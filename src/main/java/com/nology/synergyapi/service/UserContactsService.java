package com.nology.synergyapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.model.Bank;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.model.UserContactBank;

@Service
public class UserContactsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BankService bankService;

    @Autowired
    AccountRepository accountRepository;


    public List<UserContactBank> getUserContactsWithBank(Long userId) {
        List<UserContactBank> userContacts = new ArrayList<>();
        User mainUser = userRepository.findByUserID(userId);
        Set<User> contacts = mainUser.getContacts();

        contacts.forEach (contact -> {
            Account account = accountRepository.findByUserID(contact.getuserID());
            Bank bank;
            try {
                bank = bankService.getBank(account.getSortCode());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            UserContactBank userContact = new UserContactBank(contact.getFirstName(), contact.getLastName(),
                    bank.getBankName(), bank.getBankLogo(), 
                    account.getSortCode(), account.getIBAN(), account.getAccountID(), account.getCurrencyID(), account.getAccountType(), contact.getuserID());
            userContacts.add(userContact);
       });

       return userContacts;
    }

    
}
