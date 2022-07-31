package com.pokebooke.app.service;

import java.util.List;
import java.util.Optional;

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
	

	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	public Expense updateExpense(Expense expense, Long id) {
		Expense i = expenseRepository.findById(id).get();
		i.setName(expense.getName());
		i.setVendor(expense.getVendor());
		i.setDescription(expense.getDescription());
		i.setAmount(expense.getAmount());
		return expenseRepository.save(i);
	}

}
