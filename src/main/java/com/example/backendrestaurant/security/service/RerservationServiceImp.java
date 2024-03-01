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
	public ReservationDto postReservation(ReservationDto reservationDto) {

		Optional<User>optionalClient=userRepository.findById(reservationDto.getCustomerId());
		//Optional<Client> optionalClient = clientRepository.findById(String.valueOf(reservationDto.getCustomerId()));

		if(optionalClient.isPresent()) {
			Reservation reservation=new Reservation();
			reservation.setTableType(reservationDto.getTableType());
			reservation.setDateTime(reservationDto.getDateTime());
			reservation.setDescription(reservationDto.getDescription());
			reservation.setClient(optionalClient.get());
			reservation.setReservationStatus(ReservationStatus.PENDING);
			Reservation postReservation= reservationRepository.save(reservation);
			ReservationDto postReservationDto =new ReservationDto();
			postReservationDto.setId(postReservation.getId());
			return postReservationDto;
		}
		return null;
	}

}

