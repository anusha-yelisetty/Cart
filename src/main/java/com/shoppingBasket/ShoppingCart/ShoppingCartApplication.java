package com.shoppingBasket.ShoppingCart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.shoppingBasket.service.DisplayService;
import com.shoppingBasket.service.ShoppingCartService;

@SpringBootApplication
public class ShoppingCartApplication implements CommandLineRunner {
	
	@Autowired
	private static DisplayService shoppingCartService;
	
	/*
	 * Scanner sc = new Scanner(new File("src/main/resources/options.txt")); while
	 * (sc.hasNextLine()) { String line = sc.nextLine(); System.out.println(line); }
	 * 
	 * Scanner scanner = new Scanner(System.in);
	 * System.out.print("Enter your Option ? "); String input = scanner.next();
	 * System.out.println("Entered input :"+input);
	 * shoppingCartService.validateOptions(Integer.parseInt(input),scanner);
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		shoppingCartService.showOptions();
	}
}
