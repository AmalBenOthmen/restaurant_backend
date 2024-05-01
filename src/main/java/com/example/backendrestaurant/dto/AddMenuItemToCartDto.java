package com.example.backendrestaurant.dto;

import lombok.Data;

@Data
public class AddMenuItemToCartDto {
    private long userId;
    private long menuItemId;
}
