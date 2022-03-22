package com.shoppingBasket.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.shoppingBasket.api.Cart;
import com.shoppingBasket.entity.OrderProduct;

@Service
public class DisplayServiceImpl implements DisplayService{
	
	@Autowired
	private Cart cart ;

	@Autowired
	private OrderService orderService;
	
	@Override
	public void showOptions() {

		try (Scanner scanner = new Scanner(System.in)) {

			while (true) {
				System.out.println("==========OPTIONS==========");
				System.out.print("1. Display the contents available | ");
				System.out.print("2. Take order | ");
				System.out.print("3. Apply any offers available | ");
				System.out.print("4. Show the Total price | ");
				System.out.println("5. Exit System");
				System.out.print("Option: ");

				String option = scanner.next();
				switch (option) {
				case "1":
					displayAllProducts();
					break;
				case "2":
					displayOffers();
					break;
				case "3":
					takeOrders(scanner);
					break;
				case "4":
					displayCart();
					break;
				case "5":
					break;
				default:
					System.out.println("Invalid option, please re-enter.");
				}

				if ("x".equals(option)) {
					break;
				}
			}
		}

	}
	
	@Override
	public void displayAllProducts() {
		System.out.println("==========PRODUCT==========");
		if (!CollectionUtils.isEmpty(cart.getProductMap())) {
			cart.getProductMap().values().forEach(System.out::println);
		} else {
			System.out.println("No Products found!");
		}
		
	}

	@Override
	public void displayOffers() {
		System.out.println("==========OFFERS==========");
		if (!CollectionUtils.isEmpty(cart.getOfferList())) {
			cart.getOfferList().forEach(System.out::println);
		} else {
			System.out.println("No Offers found!");
		}
		
	}

	@Override
	public void takeOrders(Scanner scanner) {
		System.out.print("Enter products: ");

		scanner.nextLine();

		List<String> productsName = Arrays.asList(StringUtils.split(scanner.nextLine(), null));
		
		productsName.forEach(product -> {
			if (cart.getProductMap().containsKey(product.toUpperCase())) {
				System.out.println("Adding.. " + product);
				OrderProduct orderProduct = new OrderProduct();
				orderProduct.setProduct(cart.getProductMap().get(product.toUpperCase()));
				orderProduct.setQuantity(1);
				orderService.placeOrder(orderProduct);
			} else {
				System.out.println("Invalid product.. " + product);
			}
		});

		displayCart();
		
	}

	@Override
	public void displayCart() {
		System.out.println("==========BASKET==========");
		if (!cart.getOrderList().isEmpty()) {
			cart.getOrderList().stream()
					.collect(Collectors.groupingBy(OrderProduct::getProduct, Collectors.summingInt(OrderProduct::getQuantity)))
					.forEach((product, totalQuantity) -> {
						System.out.println(product.getName() + " x " + totalQuantity + " = "
								+ roundOff(product.getPrice().multiply(new BigDecimal(totalQuantity))));
					});
			computeTotal();
		} else {
			System.out.println("No Items in Basket!");
		}
		
	}

	@Override
	public BigDecimal computeTotal() {
		return cart.getOrderList().stream()
				.map(order -> order.getProduct().getPrice().multiply(new BigDecimal(order.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
	}

	@Override
	public BigDecimal showDiscount() {
		return cart.getAppliedOffer().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		
	}
	
	@Override
	public BigDecimal getFinalTotal() {
		return computeTotal().add(showDiscount());
	}
	
	private static BigDecimal roundOff(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_DOWN);
	}

}
