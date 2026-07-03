package com.ExpenseTracker.Service;

import java.util.List;
import java.util.Optional;

import com.ExpenseTracker.Entity.Expense;

public interface expenseService {
  Expense addExpense(Expense e);
  List<Expense> getAllExpense();
  Expense updateExpense(int id, Expense e);
  Optional<Expense> getExpense(int id);
}
