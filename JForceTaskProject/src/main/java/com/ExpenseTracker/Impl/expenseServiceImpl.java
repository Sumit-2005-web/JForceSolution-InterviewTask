package com.ExpenseTracker.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseTracker.Entity.Expense;
import com.ExpenseTracker.Repository.expeneRepo;
import com.ExpenseTracker.Service.expenseService;

@Service
public class expenseServiceImpl implements expenseService{
	
	@Autowired
	private expeneRepo erepo;

	@Override
	public Expense addExpense(Expense e) {
		// TODO Auto-generated method stub
		return erepo.save(e);
	}

	@Override
	public List<Expense> getAllExpense() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	@Override
	public Expense updateExpense(int id, Expense e) {
		// TODO Auto-generated method stub
	 Expense existingExpense = erepo.findById(id).orElseThrow(() -> new RuntimeException("Expense Not found"));
		 
		 existingExpense.setExpenseName(e.getExpenseName());
		 existingExpense.setAmount(e.getAmount());
		 existingExpense.setDate(e.getDate());
		 existingExpense.setDescription(e.getDescription());
				 
		return erepo.save(existingExpense);
		
	}

	@Override
	public Optional<Expense> getExpense(int id) {
		// TODO Auto-generated method stub
		return erepo.findById(id);
	}

}
