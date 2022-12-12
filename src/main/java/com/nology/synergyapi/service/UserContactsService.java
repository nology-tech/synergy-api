package com.nology.synergyapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.model.Bank;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.model.UserContact;
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
        List<UserContact> contacts = mainUser.getContacts();

        contacts.forEach (contact -> {
            User user=contact.getUser2();
            Account account = accountRepository.findByUserID(user.getuserID());
            Bank bank;
            try {
                bank = bankService.getBank(account.getSortCode());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            UserContactBank userContact = new UserContactBank(user.getFirstName(), user.getLastName(),
                    bank.getBankName(), bank.getBankLogo(), 
                    account.getSortCode(), account.getIBAN(), account.getAccountID(), account.getCurrencyID());
            userContacts.add(userContact);
       });

       return userContacts;
    }

    
}
