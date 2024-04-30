package com.example.backendrestaurant.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backendrestaurant.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	/*@Query("SELECT c from Commande c WHERE user_id= ?1")
	public List<Commande> findMesCommandes(Long id);*/
	
	

}
