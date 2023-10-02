package com.cydeo.springthymeleaf.service;

import com.cydeo.springthymeleaf.model.Cart;

import java.util.UUID;

public interface CartService {
    Cart addToCart (UUID productId, Integer quantity);
    boolean deleteFromCart(UUID productId) throws Exception;
}
