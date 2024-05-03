package com.example.backendrestaurant.security.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendrestaurant.models.Commande;
import com.example.backendrestaurant.models.MenuItem;
import com.example.backendrestaurant.models.User;
import com.example.backendrestaurant.repository.CommandeRepository;
import com.example.backendrestaurant.repository.MenuItemRepository;
import com.example.backendrestaurant.repository.UserRepository;



@Service
public class CommandeServiceImp implements CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public void passercommande( Long iduser, Long idmenuItem) {
		User user =userRepository.findById(iduser).get();
		MenuItem menuItem =menuItemRepository.findById(idmenuItem).get();
		Commande cmd = new Commande();
		
		cmd.setUser(user);
		cmd.setMenuItem(menuItem);
		cmd.setDatedecommande(new Date());
		commandeRepository.save(cmd);
	}
	
}
