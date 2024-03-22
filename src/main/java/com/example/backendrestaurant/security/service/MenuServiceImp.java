package com.example.backendrestaurant.security.service;

import com.example.backendrestaurant.models.Categorie;
import com.example.backendrestaurant.models.Menu;
import com.example.backendrestaurant.models.MenuItem;
import com.example.backendrestaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImp implements MenuService{
  @Autowired
  private MenuRepository menuRepository;


  @Override
  public Menu addMenu(MenuItem item, Categorie categorie) {
    Menu menu = new Menu();
    menu.setName("Your Menu Name");
    menu.setCategorie(categorie);
    menu.getMenuItems().add(item);
    return menuRepository.save(menu);  }

  @Override
  public List<Menu> MenuList() {
    return menuRepository.findAll();
  }

  @Override
  public Menu updateMenu(Menu menu, Long id) {
    Menu existingMenu = menuRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));
    existingMenu.setName(menu.getName());
    existingMenu.setCategorie(menu.getCategorie());
    existingMenu.setMenuItems(menu.getMenuItems());
    return menuRepository.save(existingMenu);  }

  @Override
  public void deleteMenuById(Long id) {
    menuRepository.deleteById(id);

  }
}
