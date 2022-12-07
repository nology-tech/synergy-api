package com.nology.synergyapi.repository;

import com.nology.synergyapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserID(Long userID);
}