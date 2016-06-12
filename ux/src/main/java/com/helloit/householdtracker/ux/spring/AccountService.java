package com.helloit.householdtracker.ux.spring;


import com.helloit.householdtracker.common.entities.Account;
import com.helloit.householdtracker.common.repository.IAccountRepository;
import com.helloit.householdtracker.common.services.IAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;


/**
 */

@Service
public class AccountService implements IAccountService {

    private static final Logger LOGGER = LogManager.getLogger(AccountService.class);

    private final IAccountRepository accountRepository;

    @Autowired
    public AccountService(final IAccountRepository userRepository) {
        this.accountRepository = userRepository;
    }


    @Override
    public CreationOutcomes createAccount(@NotNull final String accountName, @NotNull final String password, @NotNull final String retypedPassword) {
        CreationOutcomes result;

        if (password.equals(retypedPassword)) {
            final Account account = new Account();
            account.setName(accountName);
            account.setPassword(password);

            try {
                accountRepository.save(account);
                result = CreationOutcomes.SUCCESS;
            } catch (JpaSystemException ex) {
                boolean found = false;
                for (Throwable exceptionChain = ex; exceptionChain != null && !found; exceptionChain = exceptionChain.getCause()) {
                    found = exceptionChain instanceof ConstraintViolationException;
                }

                if (found) {
                    result = CreationOutcomes.EXISTING_ACCOUNT;
                } else {
                    throw ex;
                }

            }
        } else {
            result = CreationOutcomes.RETYPED_PASSWORD_DO_NOT_MATCH;
        }

        return result;
    }

    @Override
    public boolean authenticate(@NotNull final String accountName, @NotNull final String password) {
        final Account account = accountRepository.findOneByName(accountName);

        return account != null && password.equals(account.getPassword());
    }

}

