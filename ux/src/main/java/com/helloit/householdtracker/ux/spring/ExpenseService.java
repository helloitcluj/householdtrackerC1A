package com.helloit.householdtracker.ux.spring;

import com.helloit.householdtracker.common.entities.Expense;
import com.helloit.householdtracker.common.repository.IExpenseRepository;
import com.helloit.householdtracker.common.services.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 */

@Service
public class ExpenseService implements IExpenseService {

    private final IExpenseRepository expenseRepository;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    @Autowired
    public ExpenseService(final IExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    @Override
    public Expense save(final String date, final double amount,
                        final String description, final Integer accountId) {


        final Expense expense = new Expense(amount, convert(date), description, accountId);

        return expenseRepository.save(expense);
    }

    private Calendar convert(String dateAsString) {

        Calendar result = null;

        try {
            Date date = formatter.parse(dateAsString);
            result = Calendar.getInstance();
            result.setTime(date);
        } catch (final ParseException ignored) {
            //ignored
        }

        return result;
    }
}
