package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.model.UserProfile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserService {
    public static List<UserProfile> getUserData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserProfile> userData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/users.json"), new TypeReference<List<UserProfile>>() { });
        return userData;
    }
}
