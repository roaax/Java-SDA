package com.spring.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.mvc.models.Books;
import com.spring.mvc.repository.BooksRepository;


@Service
public class BooksService {

	private final BooksRepository booksRepository;
    
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    // returns all the books
    public List<Books> allBooks() {
        return booksRepository.findAll();
    }
    // creates a book
    public Books createBook(Books b) {
        return booksRepository.save(b);
    }
    // retrieves a book
    public Books findBook(Long id) {
        Optional<Books> optionalBooks = booksRepository.findById(id);
        if(optionalBooks.isPresent()) {
            return optionalBooks.get();
        } else {
            return null;
        }
    }
    //Update a book 
    public Books updateBooks(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Books  b= booksRepository.findById(id).get();
    	b.setTitle(title);
    	b.setDescription(desc);
    	b.setLanguage(lang);
    	b.setNumberOfPages(numOfPages);
    	return booksRepository.save(b);
    }
    
    
    //Delete | remove a book
    public void deleteBooks(Long id) {
   	  booksRepository.deleteById(id);
   }

    }
