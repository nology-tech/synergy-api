package com.nology.synergyapi;

import com.nology.synergyapi.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User extends JpaRepository<UserProfile, String> {
}
