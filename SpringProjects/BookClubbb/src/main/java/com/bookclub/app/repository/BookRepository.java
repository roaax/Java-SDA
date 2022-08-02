package com.bookclub.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookclub.app.models.Books;


@Repository
public interface BookRepository extends CrudRepository <Books, Long>{
	List<Books> findAll();
}