package com.example.backendrestaurant.controllers;

import com.example.backendrestaurant.models.Categorie;
import com.example.backendrestaurant.models.Menu;
import com.example.backendrestaurant.models.MenuItem;
import com.example.backendrestaurant.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;

  @PostMapping
  public Menu addMenu(@RequestBody MenuItem item, @RequestParam Long categoryId) {
    Categorie categorie = new Categorie();
    return menuService.addMenu(item, categorie);
  }

  @GetMapping
  public List <Menu> getAllMenus() {
    return menuService.MenuList();
  }

  @PutMapping("/{id}")
  public Menu updateMenu(@RequestBody Menu menu, @PathVariable Long id) {
    return menuService.updateMenu(menu, id);
  }

  @DeleteMapping("/{id}")
  public void deleteMenu(@PathVariable Long id) {
    menuService.deleteMenuById(id);
  }
}
