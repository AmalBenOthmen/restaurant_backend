package com.example.backendrestaurant.security.service;

import com.example.backendrestaurant.models.Categorie;
import com.example.backendrestaurant.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategorieServiceImp implements CatgeorieService {
  @Autowired
  private CategorieRepository categorieRepository;

  @Override
  public Categorie addCategorie(Categorie categorie) {
    if(categorie.getName()==null || categorie.getName().isEmpty()){
      throw new IllegalArgumentException("Categorie Name cannot be empty !!");
    }
    try{
      return categorieRepository.save(categorie);
    }catch (Exception e){
      throw new RuntimeException("Failed to add the categorie",e);
    }
  }

  @Override
  public List<Categorie> CategorieList() {
    return (List<Categorie>) categorieRepository.findAll();
  }

  @Override
  public Categorie updateCategorie(Categorie categorie, Long id) throws RuntimeException {
    Categorie C = categorieRepository.findById(id).get();

    if (Objects.nonNull(categorie.getName())
      && !"".equalsIgnoreCase(categorie.getName())) {
      C.setName(categorie.getName());
    }

    if (Objects.nonNull(categorie.getDescription())
      && !"".equalsIgnoreCase(
      categorie.getDescription())) {
      C.setDescription(
        categorie.getDescription());
    }
    return categorieRepository.save(C);
  }

  @Override
  public void deleteCategorieById(Long id) {
    categorieRepository.deleteById(id);
  }




}
