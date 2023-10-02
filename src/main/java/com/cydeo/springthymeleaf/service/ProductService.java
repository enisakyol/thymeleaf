package com.cydeo.springthymeleaf.service;

import com.cydeo.springthymeleaf.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    boolean productCreate(Product product);
    List<Product> listProduct();
    Product findProductById(UUID uuid);
}
