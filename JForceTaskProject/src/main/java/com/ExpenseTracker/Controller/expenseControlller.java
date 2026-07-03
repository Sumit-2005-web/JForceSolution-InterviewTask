package com.ExpenseTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ExpenseTracker.Entity.Expense;
import com.ExpenseTracker.Impl.expenseServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class expenseControlller {
  
	@Autowired
	private expenseServiceImpl esimpl;
	
	 @GetMapping("/")
	   public String home(Model m, HttpSession session) {
		 if (session.getAttribute("loggedInUser") == null) {
	            return "redirect:/login";
	        }
		  m.addAttribute("expenses", esimpl.getAllExpense());
		  return "allExpense";
	  }
	  
	  @GetMapping("/addExpense")
	  public String addTaskForm(Model m, HttpSession session) {
		  if (session.getAttribute("loggedInUser") == null) {
	            return "redirect:/login";
	        }
		  m.addAttribute("expense", new Expense());
		  return "addExpense";
	  }
	  
	  @PostMapping("/saveExpense")
	  public String saveTask(@ModelAttribute Expense e, HttpSession session) {
			 if (session.getAttribute("loggedInUser") == null) {
		            return "redirect:/login";
		        }
		  esimpl.addExpense(e);
		  return "redirect:/";
	  }
	  
	  @GetMapping("/editExpense/{id}")
	  public String editTask(@PathVariable int id, Model model, HttpSession session) {
		  
			 if (session.getAttribute("loggedInUser") == null) {
		            return "redirect:/login";
		        }

	      Expense expense = esimpl.getExpense(id)
	              .orElseThrow(() -> new RuntimeException("Expense not found"));

	      model.addAttribute("expense", expense);
	      return "editExpense";
	  }

	  @PostMapping("/updateExpense/{id}")
	  public String updateTask(@PathVariable int id, @ModelAttribute Expense e, HttpSession session) {
			 if (session.getAttribute("loggedInUser") == null) {
		            return "redirect:/login";
		        }
	      esimpl.updateExpense(id, e);
	      return "redirect:/";
	  } 
}
