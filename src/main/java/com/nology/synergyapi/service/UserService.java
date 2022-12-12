package com.nology.synergyapi.service;

import com.nology.synergyapi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public User getUserByEmail (String email, List<User> allUsers) {
        return allUsers
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);

    }

}
