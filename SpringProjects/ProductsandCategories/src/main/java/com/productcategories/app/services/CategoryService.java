package com.productcategories.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategories.app.models.Category;
import com.productcategories.app.models.Product;
import com.productcategories.app.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductService productService;
	
//	All Category
	public List<Category> allCategory(){
		return categoryRepository.findAll();
	}
	
//	Create Category 
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory= categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
//	-----------------------------ManyToMany-----------------------------------------
//	
	public List<Category> finddCategory(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	
	
	// Add Category to product
	public Category addToProduct(Category category, Long id) {
    
    // retrieve an instance of a product using another method in the service.
    Product thisProduct = productService.findProduct(id);
    // add the product to this category's list of products
    category.getProducts().add(thisProduct);   
    // Save thisCategory, since you made changes to its product list.
     return categoryRepository.save(category);	
	}

}
