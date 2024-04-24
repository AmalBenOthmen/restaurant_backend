package com.example.backendrestaurant.repository;

import com.example.backendrestaurant.models.Order;
import com.example.backendrestaurant.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long > {
    Order findByUserIdAndOrderStatus(long userId, OrderStatus orderStatus);
}

