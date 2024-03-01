package com.example.backendrestaurant.security.service;

import com.example.backendrestaurant.models.Categorie;

import java.util.List;

public interface CatgeorieService {

  Categorie addCategorie(Categorie categorie);

  List<Categorie> CategorieList() ;

  Categorie updateCategorie(Categorie categorie,Long id);

  void deleteCategorieById(Long id);
}
