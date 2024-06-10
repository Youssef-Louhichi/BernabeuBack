package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRes;
	private Date date_res;
	private int nbjoueurs;
	private int rate;
	private String feedback;
	private float tarif;
	private boolean eau;
	private String temps;
	private boolean done;
	public boolean annule;
	public LocalDateTime date_annulation;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_terrain")
	private Terrain terrain;

	public int getIdRes() {
		return idRes;
	}

	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}

	public Date getDate_res() {
		return date_res;
	}

	public void setDate_res(Date date_res) {
		this.date_res = date_res;
	}

	public int getNbjoueurs() {
		return nbjoueurs;
	}

	public void setNbjoueurs(int nbjoueurs) {
		this.nbjoueurs = nbjoueurs;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public boolean isEau() {
		return eau;
	}

	public void setEau(boolean eau) {
		this.eau = eau;
	}

	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public boolean isAnnule() {
		return annule;
	}

	public void setAnnule(boolean annule) {
		this.annule = annule;
	}

	public LocalDateTime getDate_annulation() {
		return date_annulation;
	}

	public void setDate_annulation(LocalDateTime localDateTime) {
		this.date_annulation = localDateTime;
	}
	
	

	public Reservation(Date date_res, int nbjoueurs, int rate, String feedback, float tarif, boolean eau, String temps,
			boolean done, boolean annule, LocalDateTime date_annulation, Client client, Terrain terrain) {
		super();
		this.date_res = date_res;
		this.nbjoueurs = nbjoueurs;
		this.rate = rate;
		this.feedback = feedback;
		this.tarif = tarif;
		this.eau = eau;
		this.temps = temps;
		this.done = done;
		this.annule = annule;
		this.date_annulation = date_annulation;
		this.client = client;
		this.terrain = terrain;
	}

	public Reservation() {
		super();
	}
	
	

}
