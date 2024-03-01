package com.example.backendrestaurant.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendrestaurant.dto.ReservationDto;
import com.example.backendrestaurant.security.service.ReservationService;

@RestController
@RequestMapping("/api/client")
public class ReservationController {
	  @Autowired
	  private ReservationService reservationService;

	
	@PostMapping("/reservation")
	public ResponseEntity<?>postReservation(@RequestBody ReservationDto reservationDto) throws IOException{
		ReservationDto postedRervationDto=reservationService.postReservation(reservationDto);
		if(postedRervationDto==null)return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.CREATED).body(postedRervationDto);
	}
	
	

}

