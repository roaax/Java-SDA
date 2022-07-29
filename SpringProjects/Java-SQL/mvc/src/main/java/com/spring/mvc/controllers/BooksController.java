package com.spring.mvc.controllers;


//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.models.Books;
import com.spring.mvc.services.BooksService;



@Controller
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@RequestMapping("/books/{bookId}")
	public String index(Model model,@PathVariable("bookId")Long bookId){
//		System.out.println(bookId);
		Books book= booksService.findBook(bookId);
//		System.out.println(book);
		
		model.addAttribute("book",book);
		
		
		
//		ArrayList<Books> books= (ArrayList<Books>) booksService.allBooks();
		
//		model.addAttribute("books",books);
		
		
		return "show.jsp";
	}
	
	 
	
}
