package com.helloit.householdtracker.repository;

import com.helloit.householdtracker.common.entities.Account;
import com.helloit.householdtracker.common.entities.Expense;
import com.helloit.householdtracker.common.repository.IAccountRepository;
import com.helloit.householdtracker.common.repository.IExpenseRepository;
import com.helloit.householdtracker.tools.SchemaManager;
import com.helloit.householdtracker.ux.spring.AppConfig;
import com.helloit.householdtracker.ux.spring.WebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;

/**
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class ExpenseRepositoryTest {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IExpenseRepository expenseRepository;
    private Account testAccount;

    @Before
    public void setup() {
        final SchemaManager schemaManager = new SchemaManager();
        schemaManager.recreateSchema();

        final Account account = new Account();
        account.setName("Test");
        account.setPassword("1");

        testAccount = accountRepository.save(account);
    }

    @Test
    public void basicTest() {
        Calendar now = Calendar.getInstance();
        final Expense expense = new Expense(32.5, now, "Chocolate", testAccount.getId());

        Expense saved = expenseRepository.save(expense);

        Assert.assertEquals("Should have an id of 0", new Integer(0), saved.getId());
    }

    @Test
    public void foreignKeyTest() {
        Calendar now = Calendar.getInstance();
        final Expense expense = new Expense(32.5, now, "Chocolate", testAccount.getId() - 1);

        try {
            Expense saved = expenseRepository.save(expense);
            throw new UnsupportedOperationException("Should not happen!");
        } catch (RuntimeException ex) {
            //should fail
        }
    }

}
