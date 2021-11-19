package com.lti.smartshopapplication.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.smartshopapplication.exception.ResourceNotFoundException;
import com.lti.smartshopapplication.model.Product;
import com.lti.smartshopapplication.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	private static final Logger log=Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService service;
	
	@PostMapping("/save/product")
	public Product addProduct(@RequestBody Product product) {
		log.info("start :ProductController :addProduct");
		Product p=service.addProduct(product);
		log.info("end :ProductController :addProduct");
		return p;
	}
	
	
	@GetMapping("get/allproducts")
	public List<Product> getAllProduct(){
		log.info("start :ProductController :getAllProduct");
		List<Product> products=service.getAllProduct();
		if(products.isEmpty()|| products==null) {
			throw new ResourceNotFoundException();
						
		}
		log.info("end :ProductController :getAllProduct");
		return products;
	}
	
	@PutMapping("/update/product/{productId}")
	public Product updateProduct(@RequestBody Product product, @PathVariable Integer productId) {
		log.info("start :ProductController :updateProduct");
		Product p=service.updateProduct(product, productId);
		log.info("end :ProductController :updateProduct");
		return p;
	}	
	
	@GetMapping("/getproduct/byname/{name}")
	public List<Product> getOneProductByName(@PathVariable String name) {
		log.info("start :ProductController :productByProduct");
		List<Product> p=service.getOneProductByName(name);
		if(p.isEmpty()|| p==null) {
			throw new ResourceNotFoundException();
		}
		log.info("end :ProductController :productByProduct");
		return p;
	}	
	
	@GetMapping("/getproduct/bycategory/{category}")
	public List<Product> getOneProductByCategory(@PathVariable String category) {
		log.info("start :ProductController :productByCategory");
		List<Product> p= service.getOneProductByCategory(category);
		
		if(p.isEmpty()|| p==null) {
			throw new ResourceNotFoundException();
		}
		log.info("end :ProductController :productByCategory");
		return p;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProductById(@PathVariable Integer productId) {
		log.info("start :ProductController :deleteProduct");
		service.deleteProductById(productId);
		log.info("end :ProductController :deletetByProduct");
	}
	
	
	@DeleteMapping("/delete/product/byrating/{rating}")
	public void deleteProductByRating(@PathVariable Integer rating) {
		service.deleteProductByRating(rating);
		
	}
}
