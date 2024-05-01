package com.example.backendrestaurant.security.service;

import com.example.backendrestaurant.dto.AddMenuItemToCartDto;
import com.example.backendrestaurant.dto.OrderDto;
import com.example.backendrestaurant.models.*;
import com.example.backendrestaurant.repository.CartItemRepository;
import com.example.backendrestaurant.repository.MenuItemRepository;
import com.example.backendrestaurant.repository.OrderRepository;
import com.example.backendrestaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CartItemServiceImp implements CartItemService{
    @Autowired
    private OrderRepository orderRepository;
     @Autowired
    private UserRepository userRepository;
     @Autowired
    private CartItemRepository cartItemRepository;
     @Autowired
     private MenuItemRepository menuItemRepository;


    public ResponseEntity<?> addMenuItemToCart (AddMenuItemToCartDto addMenuItemToCartDto) {
        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(addMenuItemToCartDto.getUserId(), OrderStatus.Pending);
        Optional<CartItem> optionalCartItem = cartItemRepository.findByMenuItemIdAndOrderIdAndUserId
                (addMenuItemToCartDto.getMenuItemId(), activeOrder.getId(), addMenuItemToCartDto.getUserId());


        if (optionalCartItem.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } else {
            Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(addMenuItemToCartDto.getMenuItemId());
            Optional<User> optionalUser = userRepository.findById(addMenuItemToCartDto.getUserId());
            if (optionalMenuItem.isPresent() && optionalUser.isPresent()) {
                CartItem cart = new CartItem();
                cart.setMenuItem(optionalMenuItem.get());
                cart.setPrice(optionalMenuItem.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);


                CartItem updatedCart = cartItemRepository.save(cart);

                activeOrder.setTotalAmount(activeOrder.getTotalAmount() + cart.getPrice());
                activeOrder.setAmount(activeOrder.getAmount() + cart.getPrice());
                activeOrder.getCartItem().add(cart);

                orderRepository.save(activeOrder);

                return ResponseEntity.status(HttpStatus.CREATED).body(cart);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or product not found");

            }

        }
    }


    public OrderDto getCartByUserId(Long userId) {
        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.Pending);
        OrderDto orderDto= new OrderDto();
        orderDto.setAmount (activeOrder.getAmount());
        orderDto.setId(activeOrder.getId());
        orderDto.setOrderStatus (activeOrder.getOrderStatus());
        orderDto.setDiscount (activeOrder.getDiscount());
        orderDto.setTotalAmount (activeOrder.getTotalAmount());
        return orderDto;
}
}