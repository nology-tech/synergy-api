package com.nology.synergyapi.repository;

import com.nology.synergyapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
  @Query("SELECT a FROM Account a WHERE a.user.userID = ?1")
  Account findByUserID(long userID);

  @Query("SELECT a FROM Account a WHERE a.accountID = ?1")
  Account findByAccountID(long accountID);
}
