package com.helloit.householdtracker.ux.repository;


import com.helloit.householdtracker.ux.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAccountRepository extends JpaRepository<Account, String> {

}