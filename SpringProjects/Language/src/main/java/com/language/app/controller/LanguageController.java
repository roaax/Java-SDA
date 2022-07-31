package com.language.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.language.app.models.Language;
import com.language.app.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
//main page
	@RequestMapping("/languages")
	public String form(@ModelAttribute("language") Language language, Model model) {
		List<Language> lang= languageService.allLanguage();
		model.addAttribute("lang",lang);
		
		return "index.jsp";
	}
	
//    Create a new Expense
	@RequestMapping(value="/languages",method=RequestMethod.POST )
	public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result ,Model model) {
		if(result.hasErrors()) {
			List<Language> lang = languageService.allLanguage();
			model.addAttribute("lang",lang);
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
//  Edit your Expense
	@RequestMapping("/languages/{id}/edit")
	public String edit( Model model,@PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language",language);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}",method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return"edit.jsp";
		} else {
			languageService.updateLanguage(language,id);
			return "redirect:/languages";
		}
	}
//	Show specific Expense
	   @RequestMapping("/languages/{id}")
		public String show(Model model,@PathVariable("id")Long id){
		   Language language = languageService.findLanguage(id);			
		   model.addAttribute("language",language);		
			return "show.jsp";
		}
	   

//		Delete Expense
	    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	    	languageService.deleteLanguage(id);
	        return "redirect:/languages";
	    }

}
