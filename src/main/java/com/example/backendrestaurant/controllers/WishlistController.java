package com.example.backendrestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backendrestaurant.dto.WishlistDto;
import com.example.backendrestaurant.security.service.WishlistService;


@Controller
@RequestMapping("/api/wishlist")
public class WishlistController {
	
	  @Autowired
	  private WishlistService wishlistService;

	  @PostMapping("/avis")
	  public ResponseEntity<?>addMenuItemToWishlist(@RequestBody WishlistDto wishlistDto){
		  WishlistDto postedWishlistDto =wishlistService.addMenuItemToWishlist(wishlistDto);
		//  if(postedWishlistDto==null)
			//  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
		  return ResponseEntity.status(HttpStatus.CREATED).body(postedWishlistDto);
	  }

}
