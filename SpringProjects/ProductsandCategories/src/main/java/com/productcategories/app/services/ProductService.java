package com.productcategories.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategories.app.models.Category;
import com.productcategories.app.models.Product;
import com.productcategories.app.repository.ProductRepository;



@Service
public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	
	public List<Product> allProduct(){
		return productRepository.findAll();
	}
//	Create product
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}


	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
//	-----------------------------ManyToMany-----------------------------------------
//	select add
	public List<Product> finddProduct(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
//	add category to product
	public Product addToCategory(Product product, Long categoryId) {
	    
		 Category thisCategory = categoryService.findCategory(categoryId);
//		    category.setProducts(thisProduct);
		    // add the product to this category's list of products
		    product.getCategories().add(thisCategory);
		    
		    // Save thisCategory, since you made changes to its product list.
		     return productRepository.save(product);	
		
		}
	

}
