package com.cydeo.springthymeleaf.service.impl;

import com.cydeo.springthymeleaf.model.Cart;
import com.cydeo.springthymeleaf.model.CartItem;
import com.cydeo.springthymeleaf.model.Product;
import com.cydeo.springthymeleaf.repository.ProductRepository;
import com.cydeo.springthymeleaf.service.CartService;
import com.cydeo.springthymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;
@Service
public class CartServiceImpl implements CartService {
   public static Cart CART = new Cart(BigDecimal.ZERO, new ArrayList<>());

   private final ProductService productService;
   private final ProductRepository productRepository;

    public CartServiceImpl(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }


    @Override
    public Cart addToCart(UUID productId, Integer quantity) {

        Product product = productService.findProductById(productId);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        CART.setCarTotalAmount(CART.getCarTotalAmount().add(cartItem.getTotalAmount()));

        CART.getCartItemList().add(cartItem);
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId) throws Exception {

        CartItem itemToDelete = CART.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                .findAny().orElseThrow(()-> new Exception("/Product/Cart Item not found"));

        CART.setCarTotalAmount(CART.getCarTotalAmount().subtract(itemToDelete.getTotalAmount()));

        return CART.getCartItemList().remove(itemToDelete);



    }
}
