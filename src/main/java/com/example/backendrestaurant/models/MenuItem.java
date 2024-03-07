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
  private int price;

  @ManyToMany(mappedBy = "foods")
  private Set<Categorie> categories = new HashSet<>();

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    this.price = price;
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

  public int getPrice() {
    return price;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public Set<Categorie> getCategories() {
    return categories;
  }
}

