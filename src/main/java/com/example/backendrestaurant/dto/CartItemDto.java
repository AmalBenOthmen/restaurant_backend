package com.example.backendrestaurant.dto;

import lombok.Data;

@Data
public class CartItemDto {
    private Long id;

    private Long price;

    private Long quantity;

    private  Long menuItemId;

    private Long OrderId;

    private String menuItemName;

    private byte[]returnedImg;
    private Long userId;
}

