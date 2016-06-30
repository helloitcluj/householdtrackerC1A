package com.helloit.householdtracker.common.services;

import com.helloit.householdtracker.common.entities.Account;
import org.jetbrains.annotations.NotNull;

/**
 */
public interface IAccountService {
    IAccountService.CreationOutcomes createAccount(@NotNull String accountName, @NotNull String password, @NotNull String retypedPassword);

    boolean authenticate(@NotNull String accountName, @NotNull String password);

    Account find(final String accountName);

    enum CreationOutcomes {
        EXISTING_ACCOUNT, RETYPED_PASSWORD_DO_NOT_MATCH, SUCCESS
    }

}
