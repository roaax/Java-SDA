
package com.pokebooke.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokebooke.app.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();

}
