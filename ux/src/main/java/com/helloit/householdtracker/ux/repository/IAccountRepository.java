package com.helloit.householdtracker.ux.repository;


import com.helloit.householdtracker.ux.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAccountRepository extends JpaRepository<Accounts, String> {

}