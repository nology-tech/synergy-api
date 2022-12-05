package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.UserProfile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static List<UserProfile> getUserData() throws IOException {
        List<UserProfile> userData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/users.json"), new TypeReference<List<UserProfile>>() { });
        return userData;
    }

    public static Optional<UserProfile> getUserByID(Long uid) throws IOException {
        Optional<UserProfile> userData = getUserData().stream().filter(userProfile -> userProfile.getUid().equals(uid)).findFirst();
        return userData;
    }

    public static String deleteUser(long uid) throws IOException {
        Optional<UserProfile> userData = getUserData().stream().filter(userProfile -> userProfile.getUid().equals(uid)).findFirst();
        getUserData().remove(uid);
        return "User with id: " + uid + " deleted.";
    }

    public static String createUser(UserProfile userProfile) throws IOException {
        userProfile.setUid(userProfile.getUid());
        userProfile.setFirstName(userProfile.getFirstName());
        userProfile.setLastName(userProfile.getLastName());
        userProfile.setEmail(userProfile.getEmail());
        userProfile.setAddress_houseNum(userProfile.getAddress_houseNum());
        userProfile.setAddress_streetName(userProfile.getAddress_streetName());
        userProfile.setAddress_city(userProfile.getAddress_city());
        userProfile.setAddress_state(userProfile.getAddress_state());
        userProfile.setAddress_postCode(userProfile.getAddress_postCode());
        userProfile.setUser_type(userProfile.getUser_type());
        userProfile.setCreateDateTime(new Timestamp(new Date().getTime()));
//        System.out.println(userProfile);
        getUserData().add(userProfile);
        return "User Profile: " + userProfile.toString() + " created!";
    }

    // UPDATE route
    @PutMapping("/user/{uid}")
    public static UserProfile updateFullUserProfile(long uid, UserProfile newUser) throws IOException {
        UserProfile updatedUser = new UserProfile();
        updatedUser.setUid(newUser.getUid());
        updatedUser.setFirstName(newUser.getFirstName());
        updatedUser.setLastName(newUser.getLastName());
        updatedUser.setEmail(newUser.getEmail());
        updatedUser.setAddress_houseNum(newUser.getAddress_houseNum());
        updatedUser.setAddress_streetName(newUser.getAddress_streetName());
        updatedUser.setAddress_city(newUser.getAddress_city());
        updatedUser.setAddress_state(newUser.getAddress_state());
        updatedUser.setAddress_postCode(newUser.getAddress_postCode());
        updatedUser.setUser_type(newUser.getUser_type());
        updatedUser.setCreateDateTime(newUser.getCreateDateTime());
        newUser = updatedUser;
        return newUser;
    }




}
