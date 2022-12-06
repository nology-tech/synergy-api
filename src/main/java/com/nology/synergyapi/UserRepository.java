package com.nology.synergyapi;

import com.nology.synergyapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
    Users findByUserID(Long userID);
}
