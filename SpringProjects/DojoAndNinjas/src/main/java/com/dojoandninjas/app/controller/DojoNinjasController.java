package com.dojoandninjas.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojoandninjas.app.models.Dojo;
import com.dojoandninjas.app.models.Ninja;
import com.dojoandninjas.app.services.DojoService;
import com.dojoandninjas.app.services.NinjaService;

@Controller
public class DojoNinjasController {

	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	
	
	//main page
	@RequestMapping("/dojos/new")
		public String form(@ModelAttribute("dojo") Dojo dojo, Model model) {
			return "index.jsp";
		}
		
		
//	    Create a new Dojo
		@RequestMapping(value="/dojos/new",method=RequestMethod.POST )
		public String createLookify(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result ,Model model) {
			if(result.hasErrors()) {
				return "index.jsp";
			} else {
				dojoService.createDojo(dojo);
				return "redirect:/dojos/new";
			}
		}
		
		//get form page
				@GetMapping("/ninjas/new")
				public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
					model.addAttribute("dojo",dojoService.allDojo());
					return "ninja.jsp";
				}
				
				
//			    Create a new Ninja with list of dojos
				@RequestMapping(value="/ninjas/new",method=RequestMethod.POST )
				public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result ,Model model) {
					if(result.hasErrors()) {
						model.addAttribute("dojo",dojoService.allDojo());
						return "ninja.jsp";
					} else {
						ninjaService.createNinja(ninja);
						return "redirect:/ninjas/new";
					}
				}
	
				//get form page
				@GetMapping("/dojos/{id}")
				public String viewDojo(@PathVariable("id") Long id, Model model) {
					model.addAttribute("Dojo",dojoService.findDojo(id));
					return "view.jsp";
				}
		
}
