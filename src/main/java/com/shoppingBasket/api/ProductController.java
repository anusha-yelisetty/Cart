package com.shoppingBasket.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingBasket.entity.Product;
import com.shoppingBasket.repo.ProductService;

@RestController
@EnableAutoConfiguration
public class ProductController {

	@Autowired
    ProductService productService;

    @GetMapping("/products")
    private List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    private Product getProduct(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    private void deleteProduct(@PathVariable("id") int id) {
    	productService.delete(id);
    }

    @PostMapping("/addProducts")
    private int saveProduct(@RequestBody Product product) {
    	System.out.println(product.toString());
    	productService.saveOrUpdate(product);
        return product.getId();
    }
}
