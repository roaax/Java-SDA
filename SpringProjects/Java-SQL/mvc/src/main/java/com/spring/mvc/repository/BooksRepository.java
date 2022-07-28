package com.spring.mvc.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Books;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long>{
    // this method retrieves all the books from the database
    List<Books> findAll();
    // this method finds books with descriptions containing the search string
    List<Books> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}
