package com.nology.synergyapi.service;

import com.nology.synergyapi.model.*;
import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.UserContactsRepository;
import com.nology.synergyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserContactsRepository userContactRepo;

    @Autowired
    AccountRepository accountRepo;

    public User getUserByEmail (String email, List<User> allUsers) {
        return allUsers
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);

    }

    public UserAccount createUserAndAccount (UserAccount userAccount) {
        User user = new User(userAccount.getFirstName(), userAccount.getLastName(), userAccount.getEmail(),
                userAccount.getAddress_houseNum(), userAccount.getAddress_streetName(), userAccount.getAddress_city(), userAccount.getAddress_state(), userAccount.getAddress_postCode(),
                userAccount.getContactFlag());
        userRepo.save(user);

        Account account = new Account(userAccount.getSortCode(), userAccount.getCurrencyID(), userAccount.getAccountType(), user);
        accountRepo.save(account);
        UserAccount newUserAccount = new UserAccount(user.getuserID(), account.getAccountID(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getAddress_houseNum(), userAccount.getAddress_streetName(),
                user.getAddress_city(), user.getAddress_state(), user.getAddress_postCode(), user.getContactFlag(),
                user.getCreateDateTime(), account.getAccountType(), account.getSortCode(), account.getCurrencyID());
        return newUserAccount;
    }

    public void createUserContact (Long userID, Long contactUserId) {
        System.out.println("UserID:" + userID + " ContactUserID: " + contactUserId);
        User user1 = userRepo.findByUserID(userID);
        User user2 = userRepo.findByUserID(contactUserId);
        System.out.println(user1);
        System.out.println(user2);
        UserContact userContact = new UserContact(userRepo.findByUserID(userID),userRepo.findByUserID(contactUserId) );
        System.out.println("userContact: " + userContact);
        userContactRepo.save(userContact);
        System.out.println("EXITING createUserContact");
    }
}