package com.nology.synergyapi;

import com.nology.synergyapi.model.UserContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactsRepository extends JpaRepository<UserContacts, String> {

       // we have access to build in methods like save() for POST, findAll for GET
        // We can also write our own custom methods (later)
        //Jpa will parse the names of these custom methods to look for "find" "by"
       UserContacts findByUserContactId(Long userContactID);
        // find - look for something
        // By - the condition of what is being searched or looke for
        // id - the variable


}
