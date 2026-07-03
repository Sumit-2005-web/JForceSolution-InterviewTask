package com.ExpenseTracker.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
	  @Id
	  @Column
	  @GeneratedValue (strategy = GenerationType.IDENTITY)
	  private int expenseId;
	  @Column
	  private String expenseName;
	   @Column
	  private double amount;
	   @Column
	  private LocalDate date;
	   @Column
	  private String description;
	   
	   
	   
	   public int getExpenseId() {
		return expenseId;
	}
	   public void setExpenseId(int expenseId) {
		   this.expenseId = expenseId;
	   }
	   public String getExpenseName() {
		   return expenseName;
	   }
	   public void setExpenseName(String expenseName) {
		   this.expenseName = expenseName;
	   }
	   public double getAmount() {
		   return amount;
	   }
	   public void setAmount(double amount) {
		   this.amount = amount;
	   }
	   public LocalDate getDate() {
		   return date;
	   }
	   public void setDate(LocalDate date) {
		   this.date = date;
	   }
	   public String getDescription() {
		   return description;
	   }
	   public void setDescription(String description) {
		   this.description = description;
	   }
	   
	   
	   
	   
}
