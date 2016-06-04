package com.helloit.householdtracker.common.repository;

import com.helloit.householdtracker.common.entities.Account;
import org.jetbrains.annotations.NotNull;

public interface IAccountRepository {
    CreationOutcomes createAccount(@NotNull String accountName, @NotNull String password, @NotNull String retypedPassword);

    boolean authenticate(@NotNull String accountName, @NotNull String password);

    Account save(Account entity);


    enum CreationOutcomes {
        SUCCESS,
        RETYPED_PASSWORD_DO_NOT_MATCH,
        EXISTING_ACCOUNT
    }

    Account findOneByName(String accountName);

}