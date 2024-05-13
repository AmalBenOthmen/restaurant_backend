package com.example.backendrestaurant.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendrestaurant.repository.CommandeRepository;
import com.example.backendrestaurant.security.service.CommandeService;
import com.example.backendrestaurant.models.Commande;


@RestController
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	private CommandeService commandeService;
    
	@Autowired
	private CommandeRepository commandeRepository;
	


	@PostMapping(value = "/passer/{iduser}/{idmenuItem}")
	public void Commande(@PathVariable("iduser") Long iduser, @PathVariable("idmenuItem") Long idmenuItem) {

		commandeService.passercommande(iduser, idmenuItem);
	}

	@GetMapping("/mescommandes/{id}")
	public List<Commande> getAllByid(@PathVariable Long id) {
		return commandeRepository.findMesCommandes(id);
	}
}
