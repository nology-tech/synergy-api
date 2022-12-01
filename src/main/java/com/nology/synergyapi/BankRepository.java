package com.nology.synergyapi;

import com.nology.synergyapi.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {

       // we have access to build in methods like save() for POST, findAll for GET
        // We can also write our own custom methods (later)
        //Jpa will parse the names of these custom methods to look for "find" "by"
        Bank findByName( String bankName);
        // find - look for something
        // By - the condition of what is being searched or looke for
        // id - the variable


}
