package com.ajay.practice.services;

import com.ajay.practice.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

  Product addProduct(Product product);

  boolean checkProduct(String productId);
}
