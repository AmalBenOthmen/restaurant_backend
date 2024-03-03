package com.example.backendrestaurant.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendrestaurant.dto.ReservationDto;
import com.example.backendrestaurant.models.Reservation;
import com.example.backendrestaurant.models.ReservationStatus;
import com.example.backendrestaurant.models.User;
import com.example.backendrestaurant.repository.ReservationRepository;
import com.example.backendrestaurant.repository.UserRepository;



@Service
public class RerservationServiceImp implements ReservationService{
	
	 @Autowired
	  private ReservationRepository reservationRepository;
	 
	 @Autowired
	  private UserRepository userRepository;



	 @Override
	 public Reservation postReservation(ReservationDto reservationDto) {
	     Long customerId = reservationDto.getCustomerId();

	     if (customerId != null) {
	         Optional<User> optionalUser = userRepository.findById(customerId);

	         if (optionalUser.isPresent()) {
	             Reservation reservation = new Reservation();
	             reservation.setTableType(reservationDto.getTableType());
	             reservation.setDateTime(reservationDto.getDateTime());
	             reservation.setDescription(reservationDto.getDescription());
	             reservation.setUser(optionalUser.get());
	             reservation.setReservationStatus(ReservationStatus.PENDING);

	             return reservationRepository.save(reservation);
	         }
	     }

	     return null;
	 }


}

