package com.helloit.householdtracker.common.services;

import com.helloit.householdtracker.common.entities.Expense;

import java.util.List;

/**
 */
public interface IExpenseService {
    Expense save(String date, double amount, String description, Integer accountId);

    List<Expense> findAllByAccountId(Integer id);
}
