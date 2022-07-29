package com.spring.mvc.controllers;


//import java.awt.print.Book;
//import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.models.Books;
import com.spring.mvc.services.BooksService;



@Controller
public class BooksController {
	    private final BooksService booksService;
	    
	    public BooksController(BooksService booksService) {
	        this.booksService = booksService;
	    }
	    
	    @RequestMapping("/books")
	    public String index(Model model) {
	        List<Books> books = booksService.allBooks();
	        model.addAttribute("books", books);
	        return "index.jsp";
	    
	}

	@RequestMapping("/books/{bookId}")
	public String index(Model model,@PathVariable("bookId")Long bookId){
		Books book= booksService.findBook(bookId);
		model.addAttribute("book",book);
		return "show.jsp";
	}
	
	 
	
}
