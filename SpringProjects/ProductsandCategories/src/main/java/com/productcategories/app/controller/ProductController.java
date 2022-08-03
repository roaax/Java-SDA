package com.productcategories.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.productcategories.app.models.Category;
import com.productcategories.app.models.Product;
import com.productcategories.app.services.CategoryService;
import com.productcategories.app.services.ProductService;



@Controller
public class ProductController {
	

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	
	
	//main page
	@RequestMapping("/products/new")
		public String form(@ModelAttribute("product") Product product, Model model) {
			return "index.jsp";
		}
		
		
//	    Create a new Product
		@RequestMapping(value="/products/new",method=RequestMethod.POST )
		public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result ,Model model) {
			if(result.hasErrors()) {
				return "index.jsp";
			} else {
				productService.createProduct(product);
				return "redirect:/categories/new";
			}
		}
		
		
		// page
		@RequestMapping("/categories/new")
			public String category(@ModelAttribute("category") Category category, Model model) {
				return "category.jsp";
			}
			
			
//		    Create a new Category
			@RequestMapping(value="/categories/new",method=RequestMethod.POST )
			public String createCategories(@Valid @ModelAttribute("category") Category category, BindingResult result ,Model model) {
				if(result.hasErrors()) {
					return "category.jsp";
				} else {
					categoryService.createCategory(category);
					return "redirect:/categories/new";
				}
			}
//			----------------------------Products---------------------------------------
			
//			Get Products
			@GetMapping("/products/{id}")
			public String products(@PathVariable("id") Long id, Model model) {
				Product product = productService.findProduct(id);
				model.addAttribute("product",product);
				model.addAttribute("categories",categoryService.finddCategory(product));
				return "product.jsp";
			}
			
			
//		    add categories to product
			@PostMapping(value="/products/{id}")
			public String addToProduct(@RequestParam(value="category") Long category, @PathVariable("id") Long id ) {
				Product product= productService.findProduct(id);
				productService.addToCategory( product,category);
				return "redirect:/products/{id}";

			}
//			----------------------------Categories---------------------------------------
			
//			Get Category
			@GetMapping("/categories/{id}")
			public String Category(@PathVariable("id") Long id, Model model) {
				Category category = categoryService.findCategory(id);
				model.addAttribute("category",category);
				model.addAttribute("products",productService.finddProduct(category));
				return "addCategory.jsp";
			}
			
			
//		    add categories to product
			@PostMapping(value="/categories/{id}")
			public String addToCategory(@RequestParam(value="product") Long product, @PathVariable("id") Long id ) {
				Category category = categoryService.findCategory(id);
				categoryService.addToProduct( category,product);
				return "redirect:/categories/{id}";

			}

}
