package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Reservation;

public interface ReservationRep extends JpaRepository<Reservation,Integer>{

	@Query("SELECT r FROM Reservation r WHERE r.terrain.idTer=?1 ")
	List<Reservation> findByTerrain(int terrain_id);
	
	@Query("SELECT r FROM Reservation r WHERE r.client.idCl=?1 ")
	List<Reservation> findByClient(int client_id);
	
	@Query("SELECT r FROM Reservation r WHERE r.terrain.idTer=?1 and r.date_res between ?2 and ?3")
	List<Reservation> findByTerrainAndDate(int terrain_id,Date d1,Date d2);
	
	@Query("SELECT avg(r.rate) FROM Reservation r WHERE r.terrain.idTer=?1 ")
	float rateByTerrain(int terrain_id);
	
	@Query("SELECT count(r) FROM Reservation r WHERE r.date_res>?1 and r.done=true")
	int nombreReservation(Date d);
	
	@Query("SELECT sum(r.tarif*r.nbjoueurs) FROM Reservation r WHERE r.date_res>?1 and r.done=true")
	float sommeTarif(Date d);
}
