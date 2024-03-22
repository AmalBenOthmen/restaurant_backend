package com.example.backendrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendrestaurant.dto.ReservationDto;
import com.example.backendrestaurant.models.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findAllByUserId(Long customerId);

}
