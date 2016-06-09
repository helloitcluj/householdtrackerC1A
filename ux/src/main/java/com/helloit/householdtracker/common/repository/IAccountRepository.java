package com.helloit.householdtracker.common.repository;

import com.helloit.householdtracker.common.entities.Account;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer>{

    Account findOneByName(String accountName);

}