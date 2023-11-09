package com.ajay.practice.contorllers;

import com.ajay.practice.model.Product;
import com.ajay.practice.model.User;
import com.ajay.practice.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping("/addProduct")
  public Product createProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }
}
