package com.shoppingBasket.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingBasket.api.Cart;
import com.shoppingBasket.entity.ComboOffer;
import com.shoppingBasket.entity.DiscountOffer;
import com.shoppingBasket.entity.Offer;
import com.shoppingBasket.entity.Product;

public class CartService {
	
	public static final BigDecimal TEN_PERCENT = new BigDecimal(10);
	public static final BigDecimal FIFTY_PERCENT = new BigDecimal(50);

	@Autowired
	Cart cart;

	@PostConstruct
	public void initialize() {
		loadProduct();
		loadOffer();
		cart.setOrderList(new ArrayList<>());
		cart.setAppliedOffer(new HashMap<>());
	}

	private void loadOffer() {
		List<Offer> offers = new ArrayList<>();

		Offer apple10PercentOff = new DiscountOffer("Apples 10% off", cart.getProductMap().get("APPLE"),TEN_PERCENT);

		Offer buy2TinsOfSoupGet50PercentOffOnBread = new ComboOffer("Bread 50% off",cart.getProductMap().get("SOUP"), 2, cart.getProductMap().get("BREAD"),FIFTY_PERCENT);

		offers.add(apple10PercentOff);
		offers.add(buy2TinsOfSoupGet50PercentOffOnBread);

		cart.setOfferList(offers);
	}

	private void loadProduct() {
		List<Product> products = new ArrayList<>();
		
		Product product1 = new Product("Soup",BigDecimal.valueOf(0.65));
		Product product2 = new Product("Bread",BigDecimal.valueOf(0.80));
		Product product3 = new Product("Milk",BigDecimal.valueOf(1.30));
		Product product4 = new Product("Apple",BigDecimal.valueOf(1.00));

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);

		cart.setProductMap(products.stream()
				.collect(Collectors.toMap(product -> product.getName().toUpperCase(), product -> product)));
	}

}
