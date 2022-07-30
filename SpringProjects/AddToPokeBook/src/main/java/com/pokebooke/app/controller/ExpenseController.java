package com.pokebooke.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pokebooke.app.models.Expense;
import com.pokebooke.app.service.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	

	@RequestMapping("/expenses")
	public String form(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpense();
		model.addAttribute("expenses",expenses);
		return "index.jsp";
	}
//	
	@RequestMapping(value="/expenses",method=RequestMethod.POST )
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result ,Model model) {
		List<Expense> expenses = expenseService.allExpense();
		model.addAttribute("expenses",expenses);
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
}