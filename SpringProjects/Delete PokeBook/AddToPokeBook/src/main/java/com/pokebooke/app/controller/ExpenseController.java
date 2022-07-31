package com.pokebooke.app.controller;

//import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//main page
	@RequestMapping("/expenses")
	public String form(@ModelAttribute("expense") Expense expense, Model model) {
//		List<Expense> expenses = expenseService.allExpense();
		model.addAttribute("expenses",expenseService.allExpense());
		return "index.jsp";
	}
	
//    Create a new Expense
	@RequestMapping(value="/expenses",method=RequestMethod.POST )
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result ,Model model) {
//		List<Expense> expenses = expenseService.allExpense();
		model.addAttribute("expenses",expenseService.allExpense());
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
//    Edit your Expense
	@RequestMapping("/expenses/edit/{id}")
	public String edit( Model model,@PathVariable("id") Long id) {
		Expense expenses = expenseService.findExpense(id);
		model.addAttribute("expen",expenses);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/expenses/{id}",method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("expen") Expense expense, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return"edit.jsp";
		} else {
			expenseService.updateExpense(expense,id);
			return "redirect:/expenses";
		}
	}
//	Show specific Expense
	   @RequestMapping("/expenses/{id}")
		public String show(Model model,@PathVariable("id")Long id){
		   Expense expenses = expenseService.findExpense(id);			
		   model.addAttribute("expen",expenses);		
			return "show.jsp";
		}
	   

//		Delete Expense
	    @RequestMapping(value="/expenses/delete/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
	        return "redirect:/expenses";
	    }
	}



