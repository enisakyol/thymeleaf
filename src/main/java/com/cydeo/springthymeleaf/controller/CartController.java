package com.cydeo.springthymeleaf.controller;

import com.cydeo.springthymeleaf.service.CartService;
import com.cydeo.springthymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/cart")
    public String getCart(Model model) {
    model.addAttribute("cart", CartServiceImpl.CART);
    return "cart/show-cart";
}

@GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable("productId")UUID productId,
                            @PathVariable("quantity") Integer quantity){


        cartService.addToCart(productId, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteCartItem(@PathVariable("productId") UUID productId) throws Exception {
        cartService.deleteFromCart(productId);
        return "redirect:/cart";
    }

}
