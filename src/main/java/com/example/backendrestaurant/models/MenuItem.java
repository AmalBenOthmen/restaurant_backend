package com.example.backendrestaurant.models;

import jakarta.persistence.*;

@Entity
public class MenuItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idMenu;

  private String name;

  private String description;
  private double prix;

  @ManyToOne
  @JoinColumn(name = "categorie_id")
  private Categorie categorie;
  public void setIdMenu(Long idMenu) {
    this.idMenu = idMenu;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCategorie(Categorie categorie) {
    this.categorie = categorie;
  }

  public void setPrix(double prix) {
    this.prix = prix;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

