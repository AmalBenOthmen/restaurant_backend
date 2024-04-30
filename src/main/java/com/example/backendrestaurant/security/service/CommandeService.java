package com.example.backendrestaurant.security.service;

public interface CommandeService {
	
	public void passercommande(
			Long iduser,
			Long idmenuItem);

}
