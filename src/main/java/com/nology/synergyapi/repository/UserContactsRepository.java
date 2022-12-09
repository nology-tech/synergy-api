package com.nology.synergyapi.repository;

import com.nology.synergyapi.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactsRepository extends JpaRepository<UserContact, String> {

       // we have access to build in methods like save() for POST, findAll for GET
        // We can also write our own custom methods (later)
        //Jpa will parse the names of these custom methods to look for "find" "by"
       UserContact findByUserContactId(Long userContactID);
        // find - look for something
        // By - the condition of what is being searched or looke for
        // id - the variable


}
