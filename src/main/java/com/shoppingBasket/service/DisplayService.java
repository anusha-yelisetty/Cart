package com.shoppingBasket.service;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public interface DisplayService {
	
	public void displayAllProducts();
	
	public void displayOffers();
	
	public void takeOrders(Scanner scanner);
	
	public void displayCart();
	
	public BigDecimal computeTotal();
	
	public BigDecimal showDiscount();

	BigDecimal getFinalTotal();

	void showOptions();

	

}
