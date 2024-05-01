package com.example.backendrestaurant.controllers;

import com.example.backendrestaurant.dto.AddMenuItemToCartDto;
import com.example.backendrestaurant.security.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartItemService cartItemService;

    @PostMapping("/addtocart")
    public ResponseEntity<?> addMenuItemToCart(@RequestBody AddMenuItemToCartDto addMenuItemToCartDto){
        return cartItemService.addMenuItemToCart(addMenuItemToCartDto);
    }

}
