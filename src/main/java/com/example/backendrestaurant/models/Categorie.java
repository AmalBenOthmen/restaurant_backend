package com.example.backendrestaurant.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Categorie {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idCategory;
  private String name;
  private String description;

  @ManyToMany
  @JoinTable(name = "food_category",
              joinColumns = @JoinColumn(name = "category_id"),
              inverseJoinColumns = @JoinColumn(name = "id"))
  private Set<MenuItem> foods = new HashSet<>();

  public void setId(Long idCategory) {
    this.idCategory = idCategory;
  }

  public Long getId() {
    return idCategory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<MenuItem> getFoods() {
    return foods;
  }
}
