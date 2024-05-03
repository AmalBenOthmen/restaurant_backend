package com.example.backendrestaurant.models;

import java.io.Serializable;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "Commande")
public class Commande implements Serializable {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Temporal(TemporalType.DATE)
		private Date datedecommande ;
		
		@ManyToOne
		@JsonBackReference
		@JsonIgnore
		private User user;
		
		@ManyToOne
	    private MenuItem menuItem;
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getDatedecommande() {
			return datedecommande;
		}

		public void setDatedecommande(Date datedecommande) {
			this.datedecommande = datedecommande;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		public MenuItem getMenuItem() {
			return menuItem;
		}

		public void setMenuItem(MenuItem menuItem) {
			this.menuItem = menuItem;
		}

		public Commande(Long id, Date datedecommande, User user, MenuItem menuItem) {
			super();
			this.id = id;
			this.datedecommande = datedecommande;
			this.user = user;
			this.menuItem = menuItem;
		}

		

		public Commande() {
			super();
		}

		@Override
		public String toString() {
			return "Commande [id=" + id + ", datedecommande=" + datedecommande + ", user=" + user + ", menuItem="
					+ menuItem + "]";
		}

		
		
		
		
			
			
			
	}

