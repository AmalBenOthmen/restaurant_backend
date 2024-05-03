package com.example.backendrestaurant.security.service;

import java.util.List;

import com.example.backendrestaurant.models.Commande;

public interface CommandeService {
	
	public void passercommande(
			Long iduser,
			Long idmenuItem);
	


}
