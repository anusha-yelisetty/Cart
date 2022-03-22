package com.shoppingBasket.entity;

import java.math.BigDecimal;
import java.util.List;

public abstract class Offer {
	
	protected String name;
	protected Product product;

	public Offer(String name, Product product) {
		
	}

	public abstract BigDecimal getDiscount(List<OrderProduct> orderProduct);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
