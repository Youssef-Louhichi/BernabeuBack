package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Terrain implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTer;
	
	private float largeur;
	private float longeur;
	private String type;
	private float prix;
	private boolean dispo;
	private String url;
	
	

	@JsonIgnore
	@OneToMany(mappedBy="terrain",cascade=CascadeType.ALL)
	private List<Reservation> reservations;

	public int getIdTer() {
		return idTer;
	}

	public void setIdTer(int idTer) {
		this.idTer = idTer;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getLongeur() {
		return longeur;
	}

	public void setLongeur(float longeur) {
		this.longeur = longeur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


	public Terrain(float largeur, float longeur, String type, float prix, boolean dispo, String url,
			List<Reservation> reservations) {
		super();
		this.largeur = largeur;
		this.longeur = longeur;
		this.type = type;
		this.prix = prix;
		this.dispo = dispo;
		this.url = url;
		this.reservations = reservations;
	}

	public Terrain() {
		super();
	}
	
	
	

}
