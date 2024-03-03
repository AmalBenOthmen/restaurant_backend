package com.example.backendrestaurant.security.service;

import com.example.backendrestaurant.dto.ReservationDto;
import com.example.backendrestaurant.models.Reservation;

public interface ReservationService {
	Reservation postReservation(ReservationDto reservationDto);

}
