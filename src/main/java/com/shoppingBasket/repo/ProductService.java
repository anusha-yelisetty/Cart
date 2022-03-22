package com.shoppingBasket.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingBasket.entity.Product;

@Service
public class ProductService  {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    public void saveOrUpdate(Product product) {
    	System.out.println("Saving ");
    	productRepository.save(product);
    }

    public void delete(int id) {
    	productRepository.deleteById(id);
    }
	

}
