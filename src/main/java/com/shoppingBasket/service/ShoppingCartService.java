package com.shoppingBasket.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
	
	@Autowired
	DisplayService displayService;
	
	public void validateOptions(int input,Scanner scanner) {
		
		switch (input) {
		case 1:
			displayService.displayAllProducts();
			break;
		case 2:
			displayService.takeOrders(scanner);
			break;
		case 3:
			displayService.displayOffers();
			break;
		case 4:
			displayService.getFinalTotal();
			break;
		case 5:
			
			break;
		
		default:
			System.out.println("Invalid option, please re-enter.");
			break;
		}

		

		}
		
	}


