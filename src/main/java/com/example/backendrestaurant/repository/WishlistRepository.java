package com.example.backendrestaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendrestaurant.models.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {


}
