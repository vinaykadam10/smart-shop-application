package com.lti.smartshopapplication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable {

	@Id
	@GeneratedValue
	@Column
	private Integer productId;
	
	@Column
	private String name;
	
	@Column
	private String category;
	
	@Column
	private Integer quantity;
	
	@Column
	private Float unitPrice;
	
	@Column
	private Float totalPrice;
	
	@Column
	private Integer rating;

	public Product() {
		super();
	}
	
	

	public Product(Integer productId) {
		super();
		this.productId = productId;
	}



	public Product(Integer productId, String name, String category, Integer quantity, Float unitPrice, Float totalPrice,
			Integer rating) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.rating = rating;
	}



	public Integer getProductId() {
		return productId;
	}



	public void setProductId(Integer productId) {
		this.productId = productId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Float getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}



	public Float getTotalPrice() {
		return unitPrice*quantity;
	}



	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", rating=" + rating + "]";
	}
	
	
	
}
