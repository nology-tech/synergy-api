package com.nology.synergyapi.service;

import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.model.UserAccount;
import com.nology.synergyapi.model.UserContactBank;
import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    AccountRepository accountRepo;

    public User getUserByEmail (String email, List<User> allUsers) {
        return allUsers
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);

    }

    public User createUserAndAccount (UserAccount userAccount) {
        User user = new User(userAccount.getFirstName(), userAccount.getLastName(), userAccount.getEmail(),
                userAccount.getAddress_houseNum(), userAccount.getAddress_streetName(), userAccount.getAddress_city(), userAccount.getAddress_state(), userAccount.getAddress_postCode(),
                userAccount.getContactFlag());

        userRepo.save(user);

        Account account = new Account(userAccount.getSortCode(), userAccount.getCurrencyID(), userAccount.getAccountType(), user);

        accountRepo.save(account);

        return user;
    }

    public User createUserContact (String userID, UserAccount userAccount) {
        User user = new User(userAccount.getFirstName(), userAccount.getLastName(), userAccount.getEmail(),
                userAccount.getAddress_houseNum(), userAccount.getAddress_streetName(), userAccount.getAddress_city(), userAccount.getAddress_state(), userAccount.getAddress_postCode(),
                userAccount.getContactFlag());

        userRepo.save(user);

        Account account = new Account(userAccount.getSortCode(), userAccount.getCurrencyID(), userAccount.getAccountType(), user);

        accountRepo.save(account);

        return user;
    }
}