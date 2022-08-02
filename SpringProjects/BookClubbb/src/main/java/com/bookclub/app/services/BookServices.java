package com.bookclub.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.app.models.Books;
import com.bookclub.app.repository.BookRepository;



@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;
  
    
    public List<Books> allBook(){
		return bookRepository.findAll();
	}
	public Books createBook(Books book) {
		return bookRepository.save(book);
	}
	
	public Books findBook(Long id) {
		Optional<Books> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	
	public Books updateBook(Books book, Long id) {
		Books i = bookRepository.findById(id).get();
		i.setTitle(book.getTitle());
		i.setAuthorName(book.getAuthorName());
		i.setThoughts(book.getThoughts());
		return bookRepository.save(i);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
