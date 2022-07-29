package com.spring.mvc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.spring.mvc.models.Books;
import com.spring.mvc.services.BooksService;

@RestController
public class BooksApi {
	private final BooksService booksService;
	
    public BooksApi(BooksService bookService){
        this.booksService = bookService;
    }
    
    @RequestMapping("/api/books")
    public List<Books> index() {
        return booksService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Books create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Books books = new Books(title, desc, lang, numOfPages);
        return booksService.createBook(books);
    }
    
    @RequestMapping("/api/books/{id}")
    public Books show(@PathVariable("id") Long id) {
        Books books = booksService.findBook(id);
        return books;
    }
    
 // other methods removed for brevity
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Books update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        Books books = booksService.updateBooks(id, title, desc, lang, numOfPages);
        return books;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        booksService.deleteBooks(id);
    }
}
