package com.shoppingBasket.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shoppingBasket.entity.Offer;
import com.shoppingBasket.entity.OrderProduct;
import com.shoppingBasket.entity.Product;

@Service
public class Cart {

	public Map<String, Product> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Product> productMap) {
		this.productMap = productMap;
	}

	public List<Offer> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<Offer> offerList) {
		this.offerList = offerList;
	}

	public List<OrderProduct> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderProduct> orderList) {
		this.orderList = orderList;
	}

	public Map<String, BigDecimal> getAppliedOffer() {
		return appliedOffer;
	}

	public void setAppliedOffer(Map<String, BigDecimal> appliedOffer) {
		this.appliedOffer = appliedOffer;
	}

	private Map<String, Product> productMap;
	private List<Offer> offerList;

	private List<OrderProduct> orderList;
	private Map<String, BigDecimal> appliedOffer;

	public void addOrder(OrderProduct order) {
		orderList.add(order);
	}

	public void addApliedOffer(String offerName, BigDecimal amount) {
		appliedOffer.put(offerName, amount);
	}

	

}
