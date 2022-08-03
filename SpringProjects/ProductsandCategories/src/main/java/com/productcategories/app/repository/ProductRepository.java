package com.productcategories.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productcategories.app.models.Category;
import com.productcategories.app.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
	// Retrieves a list of all products for a particular category
//    List<Product> findAllByProducts(Category category);
    
    // Retrieves a list of any products a particular category
    // does not belong to.

}