package com.example.backendrestaurant.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendrestaurant.dto.ReservationDto;
import com.example.backendrestaurant.models.Reservation;
import com.example.backendrestaurant.security.service.ReservationService;

import jakarta.validation.ValidationException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ReservationController {
	  @Autowired
	  private ReservationService reservationService;

	
	  @PostMapping("/reservation")
	  public ResponseEntity<?> postReservation(@RequestBody ReservationDto reservationDto) {
	      try {
	          // Validation logic

	          // If validation passes, process the reservation
	          Reservation postedReservation = reservationService.postReservation(reservationDto);
	          return ResponseEntity.status(HttpStatus.CREATED).body(postedReservation);
	      } catch (ValidationException e) {
	          // If validation fails, return a detailed error response
	          return ResponseEntity.badRequest().body(e.getMessage());
	      } catch (Exception e) {
	          // Handle other exceptions
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	      }
	  }

	
	

}

