package com.shoppingBasket.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiscountOffer extends Offer {
	
	private BigDecimal discountPercentage;
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

	public DiscountOffer(String name, Product product, BigDecimal discountPercentage) {
		super(name, product);
		this.discountPercentage = discountPercentage;
	}

	@Override
	public BigDecimal getDiscount(List<OrderProduct> orders) {

		return orders.stream().filter(order -> order.getProduct().equals(this.getProduct()))
		.map(order -> order.getProduct().getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add)
		.multiply(discountPercentage).divide(ONE_HUNDRED).negate();
	}

	public String toString() {
		return super.getName();
	}

	





}
