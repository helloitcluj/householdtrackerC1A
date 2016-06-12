package com.helloit.householdtracker.common.services;

import com.helloit.householdtracker.ux.spring.AccountService;
import org.jetbrains.annotations.NotNull;

/**
 */
public interface IAccountService {
    enum CreationOutcomes {
        EXISTING_ACCOUNT, RETYPED_PASSWORD_DO_NOT_MATCH, SUCCESS
    }

    IAccountService.CreationOutcomes createAccount(@NotNull String accountName, @NotNull String password, @NotNull String retypedPassword);

    boolean authenticate(@NotNull String accountName, @NotNull String password);
}
