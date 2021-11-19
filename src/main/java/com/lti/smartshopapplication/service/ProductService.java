package com.lti.smartshopapplication.service;

import java.util.List;

import com.lti.smartshopapplication.model.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public Product updateProduct(Product product, Integer productId);
	public void deleteProductById(Integer productId);
	public void deleteProductByRating(Integer rating);
	
	public List<Product> getOneProductByName(String name);
	public List<Product> getOneProductByCategory(String category);
	public List<Product> getAllProduct();
}
