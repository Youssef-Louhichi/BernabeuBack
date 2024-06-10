package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCl;
	
	private String nom;
	private String prenom;
	private String mdp;
	private Date date_naissance;
	private String tel;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL)
	private List<Reservation> reservations;

	public int getIdCl() {
		return idCl;
	}

	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Client(String nom, String prenom, String mdp, Date date_naissance, String tel, String email,
			List<Reservation> reservations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.date_naissance = date_naissance;
		this.tel = tel;
		this.email = email;
		this.reservations = reservations;
	}

	public Client() {
		super();
	}
	
	
	
	
	

}
