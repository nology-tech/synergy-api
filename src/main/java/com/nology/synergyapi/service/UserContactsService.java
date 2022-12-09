package com.nology.synergyapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    BankService bankService;

    public List<UserContactBank> getUserContactsWithBank(Long userId) {
        List<UserContactBank> userContacts = new ArrayList<>();
        User mainUser = userRepository.findByUserID(userId);
        List<UserContact> contacts = mainUser.getContacts();

        System.out.println(mainUser);

        contacts.forEach (contact -> {
            System.out.println(contact);
            User user=contact.getUser2();
            System.out.println(user);
            Account account = user.getAccount();
            System.out.println(account);
            Bank bank;
            try {
                bank = bankService.getBank(account.getSortCode());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(bank);
            UserContactBank userContact = new UserContactBank(user.getFirstName(), user.getLastName(), 
                    bank.getBankName(), bank.getBankLogo(), 
                    account.getSortCode(), account.getIBAN(), account.getAccountID(), account.getCurrencyID());
            userContacts.add(userContact);
       });

       System.out.println(userContacts);
       return userContacts;
    }

    
}
