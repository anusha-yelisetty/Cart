package com.shoppingBasket.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
 
	@Id
    @GeneratedValue
    private int id;
    private String name;
    private BigDecimal price;
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
    

}
