package com.ajay.practice.services.Impl;

import com.ajay.practice.model.Product;
import com.ajay.practice.services.ProductService;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private Map<String ,Product> productRepository = new HashMap<>();
    @Override
    public Product addProduct(Product product) {
        if(StringUtil.isNullOrEmpty(product.getId())){
            throw new RuntimeException("invalid UserId");
        }else if(productRepository.containsKey(product.getId())){
            throw new RuntimeException("user already exists");
        }
        productRepository.put(product.getId(), product);
        return product;
    }

    @Override
    public boolean checkProduct(String productId) {
        return productRepository.containsKey(productId);
    }
}
