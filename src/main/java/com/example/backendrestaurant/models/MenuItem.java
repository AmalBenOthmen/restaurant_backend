package com.example.backendrestaurant.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class MenuItem {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String description;
  private float prix;

  @ManyToMany(mappedBy = "foods")
  private Set<Categorie> categories = new HashSet<>();


  public void setIdMenu(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrix(float prix) {
    this.prix = prix;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public float getPrix() {
    return prix;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public Set<Categorie> getCategories() {
    return categories;
  }
}

