package com.example.demo.services;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Reservation;
import com.example.demo.repositories.ReservationRep;

@Service
public class ReservationService implements IReservationService{
	
	@Autowired
	private ReservationRep rr;

	@Override
	public boolean insertReservation(Reservation r) {
		r.setFeedback(null);
		r.setRate(0);
		r.setDone(false);
		r.setAnnule(false);
		r.setDate_annulation(null);
		return this.rr.save(r)!=null;
	}

	@Override
	public Reservation updateReservation(int id, Reservation r) {
		Reservation exReservation = rr.findById(id).get();

        if (exReservation != null) {
        	
        	exReservation.setDate_res(r.getDate_res());

        	exReservation.setEau(r.isEau());


        	
        	exReservation.setNbjoueurs(r.getNbjoueurs());
        	exReservation.setTemps(r.getTemps());
        	exReservation.setTarif(r.getTarif());
        	


        	rr.save(exReservation);

        	}

        return exReservation;
	}

	@Override
	public List<Reservation> selectAll() {
		// TODO Auto-generated method stub
		return this.rr.findAll();
	}

	@Override
	public Reservation getReservationById(int id) {
		// TODO Auto-generated method stub
		return this.rr.findById(id).get();
	}

	@Override
	public boolean deleteReservation(int id) {
		if(this.rr.existsById(id)) {
			 this.rr.deleteById(id);
			return true;
			}
			return false;
	}

	@Override
	public Reservation addFeedback(int id, String f) {
		Reservation exReservation = rr.findById(id).get();

        if (exReservation != null) {
        	
        	exReservation.setFeedback(f);
        	
        	


        	rr.save(exReservation);

        	}

        return exReservation;
	}

	@Override
	public Reservation addRate(int id, int r) {
		Reservation exReservation = rr.findById(id).get();

        if (exReservation != null) {
        	
        	exReservation.setRate(r);

        	rr.save(exReservation);

        	}

        return exReservation;
	}

	@Override
	public Reservation resDone(int id) {
		Reservation res = rr.findById(id).get();

        if (res != null) {
        	res.setDone(true);
        	rr.save(res);
        }
        
        return res;
	}

	@Override
	public Reservation resUndone(int id) {
		Reservation res = rr.findById(id).get();

        if (res != null) {
        	res.setDone(false);
        	rr.save(res);
        }
        
        return res;
	}

	@Override
	public List<Reservation> reservationParTerrain(int id) {
		return this.rr.findByTerrain(id);
	}
	
	@Override
	public List<Reservation> reservationParClient(int id) {
		return this.rr.findByClient(id);
	}
	
	@Override
	public int nombreReservation(Date d) {
		return this.rr.nombreReservation(d);
	}
	
	
	@Override
	public List<Reservation> reservationParTerrainEtDate(int id,LocalDate d1,LocalDate d2){
		return this.rr.findByTerrainAndDate(id, d1, d2);
	}

	@Override
	public Reservation resAnnulé(int id) {
		Reservation res = rr.findById(id).get();

        if (res != null) {
        	res.setAnnule(true);
        	res.setDone(false);
        	res.setDate_annulation(LocalDateTime.now());
        	rr.save(res);
        }
        
        return res;
	}
	
	

}
