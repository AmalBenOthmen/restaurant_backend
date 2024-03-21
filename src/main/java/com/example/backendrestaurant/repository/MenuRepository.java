package com.example.backendrestaurant.repository;

import com.example.backendrestaurant.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
