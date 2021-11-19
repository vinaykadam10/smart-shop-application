package com.lti.smartshopapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.smartshopapplication.exception.ResourceNotFoundException;
import com.lti.smartshopapplication.model.Product;
import com.lti.smartshopapplication.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public Product updateProduct(Product product, Integer productId) {
		
		return repo.save(product);
	}

	@Override
	public void deleteProductByRating(Integer rating){
		if(rating<2 ) {
		repo.deleteByRating(rating);
		}
	}

	@Override
	public List<Product> getOneProductByName(String name){

			
			List<Product> products=repo.getOneProductByName(name);
			
			return products;
				
	}
	
	@Override
	public List<Product> getOneProductByCategory(String category) {
		
		return repo.getOneProductByCategory(category);
	}	

	@Override
	public List<Product> getAllProduct() {

		return repo.findAll();
	}

	@Override
	public void deleteProductById(Integer productId) {
		repo.deleteById(productId);
		
	}

	
}
