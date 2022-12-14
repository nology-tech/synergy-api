package com.nology.synergyapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nology.synergyapi.model.*;
import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.UserContactsRepository;
import com.nology.synergyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContactsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BankService bankService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private UserContactsRepository userContactsRepository;

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
                    account.getSortCode(), account.getIBAN(), account.getAccountID(), account.getCurrencyID(), account.getAccountType(), user.getuserID());
            userContacts.add(userContact);
       });

       return userContacts;
    }
    public UserContact deleteUserContact(Long userID, Long contactID) {
        List<UserContact> allContacts = userContactsRepository.findAll().stream().filter(userContact->userContact.getUser().getuserID().equals(userID)).toList();
        UserContact delContact = allContacts.stream().filter(contact->contact.getUser2().getuserID().equals(contactID)).findFirst().orElse(null);
        return delContact;
    }

    public void deleteUser(Long contactID) {
        userRepository.delete(userRepository.findByUserID(contactID));
    }
}
