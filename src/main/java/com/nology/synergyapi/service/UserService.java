package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.UserProfile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static ObjectMapper objectMapper = new ObjectMapper();
//    List<UserProfile> userData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/users.json"), new TypeReference<List<UserProfile>>() { });

    public static List<UserProfile> getUserData() throws IOException {
        List<UserProfile> userData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/users.json"), new TypeReference<List<UserProfile>>() { });
        return userData;
    }
    public static Optional<UserProfile> getUserByID(Long uid) throws IOException {

        Optional<UserProfile> userData = getUserData().stream().filter(userProfile -> userProfile.getUid().equals(uid)).findFirst();
        System.out.println(userData);
        return userData;
    }
}
