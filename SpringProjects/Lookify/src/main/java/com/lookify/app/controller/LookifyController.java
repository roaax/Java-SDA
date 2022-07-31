package com.lookify.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lookify.app.models.Lookify;
import com.lookify.app.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
//main page
	@RequestMapping("/")
	public String form() {
		return "index.jsp";
	}
//dashboard
	@RequestMapping("/dashboard")
	public String form(@ModelAttribute("lookify") Lookify lookify, Model model) {
//		List<Expense> expenses = expenseService.allExpense();
		model.addAttribute("lookify",lookifyService.allLookify());
		return "dashboard.jsp";
	}
	
	//getSongs
	@RequestMapping("/songs/new")
	public String createpage(@ModelAttribute("look") Lookify lookify, Model model) {
//		List<Expense> expenses = expenseService.allExpense();
		model.addAttribute("lookify",lookifyService.allLookify());
		return "New.jsp";
	}
	
	
	//    Create a new Expense
	@RequestMapping(value="/songs/new",method=RequestMethod.POST )
	public String createLookify(@Valid @ModelAttribute("look") Lookify lookify, BindingResult result ,Model model) {
//		List<Expense> expenses = expenseService.allExpense();
		//model.addAttribute("lookify",lookifyService.allLookify());
		if(result.hasErrors()) {
			return "New.jsp";
		} else {
			lookifyService.createLookify(lookify);
			return "redirect:/dashboard";
		}
	}
		
//	delete Song
	 @RequestMapping(value="/dashboard/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
		 lookifyService.deleteLookify(id);
	        return "redirect:/dashboard";
	    }
//	 Show specific song
	 @RequestMapping("/songs/{id}")
		public String show(Model model,@PathVariable("id")Long id){
		   Lookify lookify = lookifyService.findLookify(id);			
		   model.addAttribute("lookify",lookify);		
			return "show.jsp";
		}
	 
//	 Search by artist
	 @RequestMapping("/search")
		public String search(Model model,@RequestParam("artist") String artist){
			return "redirect:/search/"+artist;
		}
	 
	 @RequestMapping("/search/{artist}")
		public String artist(Model model,@PathVariable("artist") String artist){
		   List<Lookify> song = lookifyService.findArtist(artist);			
		   model.addAttribute("song",song);
		   model.addAttribute("artist",artist);
			return "search.jsp";
		}
	 @RequestMapping("/search/topTen")
		 public String topTen(Model model){
			   model.addAttribute("topTen",lookifyService.topTen());
			   return "topTen.jsp";
		}
}
