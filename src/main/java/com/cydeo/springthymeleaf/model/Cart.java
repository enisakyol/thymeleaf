package com.cydeo.springthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private BigDecimal carTotalAmount;
    private List<CartItem> cartItemList;
}
