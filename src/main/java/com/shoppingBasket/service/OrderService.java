package com.shoppingBasket.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingBasket.api.Cart;
import com.shoppingBasket.entity.OrderProduct;

@Service
public class OrderService {
	
	@Autowired
	private Cart cart;

	public void placeOrder(OrderProduct order) {
		cart.addOrder(order);
		applyOffer();
	}

	private void applyOffer() {
		cart.getOfferList().forEach(offer -> {
			BigDecimal discount = offer.getDiscount(cart.getOrderList());
			if (discount.compareTo(BigDecimal.ZERO) < 0) {
				cart.addApliedOffer(offer.getName(), discount);
			}
		});
	}

	public BigDecimal getSubTotal() {
		return cart.getOrderList().stream()
				.map(order -> order.getProduct().getPrice().multiply(new BigDecimal(order.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal getDiscountTotal() {
		return cart.getAppliedOffer().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal getFinalTotal() {
		return getSubTotal().add(getDiscountTotal());
	}
}
