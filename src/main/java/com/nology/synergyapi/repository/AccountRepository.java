package com.nology.synergyapi.repository;

import com.nology.synergyapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String>{



//          Repository
//              |
//        CrudRepository
//              |
//         JpaRepository
// we have access to all of the CRUD operations inherited from CrudRepository

        // we have access to built in methods like save() for POST, findAll for GET
        // we can also write our own custom methods (later)
        // jpa will parse the names of these custom methods to look for "find" "by" "distinct"
        // and it will generate a jpa query language and will create a custom method

        Account findByid(String id);
        // find - searching for something
        // By - the condition fo what's being searched for
        // id - the variable
//     Account findById(String id);
}
