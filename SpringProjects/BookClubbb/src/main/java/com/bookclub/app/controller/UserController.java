package com.bookclub.app.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.app.models.Books;
import com.bookclub.app.models.LoginUser;
import com.bookclub.app.models.User;
import com.bookclub.app.services.BookServices;
import com.bookclub.app.services.UserServices;

	

	@Controller
	public class UserController {

	    @Autowired
	    private UserServices userServ;
	    @Autowired
	    private BookServices bookServ;
	    @GetMapping("/")
	    public String index(Model model) {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/books";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/books";
	    }


	    @GetMapping("/books")
	    public String home(Model model, HttpSession session) {
	        Long user_id = (Long)session.getAttribute("user_id");
	        if(user_id != null) {
	            User user = userServ.findUserById(user_id);
	            model.addAttribute("user", userServ.findUserById( (long) session.getAttribute("user_id")));
	            model.addAttribute("book",bookServ.allBook());
	            return "home.jsp";
	        }
	        else {
	            return "redirect:/";
	        }
	    }

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.removeAttribute("user_id");
	        return "redirect:/";
	    }
	    
	    
	    
	  //get book
		@RequestMapping("/books/new")
		public String createpage(@ModelAttribute("book") Books book, HttpSession session) {
			Long user_id = (Long)session.getAttribute("user_id");
	        if(user_id != null) {
	        	return "new.jsp";	
	        }else {
	        	return "redirect:/books";
	        }
		
		}
		
		
		//    Create a new Book
		@RequestMapping(value="/books/new",method=RequestMethod.POST )
		public String createBook(@Valid @ModelAttribute("book") Books book, BindingResult result ,HttpSession session) {
		    Long user_id = (Long)session.getAttribute("user_id");	
		    if(user_id != null) {
	            User user = userServ.findUserById(user_id);
				if(result.hasErrors()) {
					return "new.jsp";
				} else {
					book.setUser(user);
					bookServ.createBook(book);
					return "redirect:/books";
				}
		    }
		    return "redirect:/";
	}
//		Show Book Details
		@RequestMapping("/books/{id}")
		public String show(Model model,@PathVariable("id")Long id,HttpSession session){
			Long user_id = (Long)session.getAttribute("user_id");
			if(user_id != null) {
	           model.addAttribute("user",user_id);
	 		   model.addAttribute("book",bookServ.findBook(id));		
	 			return "show.jsp";
	 		}
				
		    
		    return "redirect:/";
	}
		   
		
	}
