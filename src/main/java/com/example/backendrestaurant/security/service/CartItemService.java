package com.example.backendrestaurant.security.service;

import com.example.backendrestaurant.dto.AddMenuItemToCartDto;
import org.springframework.http.ResponseEntity;

public interface CartItemService {
    ResponseEntity<?> addMenuItemToCart(AddMenuItemToCartDto addMenuItemToCartDto);

}
