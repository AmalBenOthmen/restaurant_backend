package com.example.backendrestaurant.controllers;

import com.example.backendrestaurant.security.service.CatgeorieService;
import com.example.backendrestaurant.models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

  @Autowired
  private CatgeorieService categorieService;

  // http://localhost:5000/addcategorie
  @PostMapping("/addcategorie")
  public Categorie addCategorie(@RequestBody Categorie categorie){

    return categorieService.addCategorie(categorie);
  }

  // http://localhost:5000/all-categories
  @GetMapping("/all-categories")
  public List<Categorie> fetchCategorieList()
  {
    return categorieService.CategorieList();
  }

  // http://localhost:5000/update-categorie/{id}
  @PutMapping("/update-categorie/{id}")
  public Categorie updateCategorie(@RequestBody Categorie categorie,@PathVariable("id") Long id)
  {
    return categorieService.updateCategorie(categorie,id);
  }

  //http://localhost:5000/delete-categorie/{id}
  @DeleteMapping("/delete-categorie/{id}")
  public String deleteCategorieById(@PathVariable("id") Long id)
  {
    categorieService.deleteCategorieById(id);
    return ("Category Has been Deleted Successfully");
  }


}
