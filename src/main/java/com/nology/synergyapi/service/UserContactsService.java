package com.nology.synergyapi.service;

import java.util.ArrayList;
import java.util.List;

import com.nology.synergyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.model.Bank;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.model.UserContact;
import com.nology.synergyapi.model.UserContactBank;

public class UserContactsService {
    @Autowired
    private static UserRepository userRepository;

    public List<UserContactBank> getUserContactsWithBank(Long userid) {
        List<UserContactBank> userContacts = new ArrayList<>();
        User mainUser = userRepository.findByUserID(userid);
        List<UserContact> contacts = mainUser.getUserContacts();

        contacts.forEach (contact -> {
            User user=userRepository.findByUserID(contact.getContactId());
            Account account = user.getAccount();
            Bank bank = account.getBank();
            UserContactBank userContact = new UserContactBank(user.getFirstName(), user.getLastName(), 
                    bank.getBankName(), bank.getBankLogo(), 
                    account.getSortCode(), account.getIBAN(), account.getAccountID(), account.getCurrencyID());
            userContacts.add(userContact);
       });

       return userContacts;
    }

    
}
