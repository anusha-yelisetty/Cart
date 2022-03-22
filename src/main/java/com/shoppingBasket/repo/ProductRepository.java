package com.shoppingBasket.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.shoppingBasket.entity.Product;

@Service
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
