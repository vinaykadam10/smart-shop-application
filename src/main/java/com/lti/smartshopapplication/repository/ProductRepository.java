package com.lti.smartshopapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.smartshopapplication.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> getOneProductByName(String name);
	public List<Product> getOneProductByCategory(String category);
	public void deleteByRating(Integer rating);
	

}
