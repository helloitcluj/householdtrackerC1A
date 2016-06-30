package com.helloit.householdtracker.common.services;

import com.helloit.householdtracker.common.entities.Expense;

import java.util.Calendar;

/**
 */
public interface IExpenseService {
    Expense save(Calendar date, double amount, String description, Integer accountId);
}
