package com.pokebooke.app.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.pokebooke.app.models.Expense;
import com.pokebooke.app.repository.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpense(){
		return expenseRepository.findAll();
	}
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

}
