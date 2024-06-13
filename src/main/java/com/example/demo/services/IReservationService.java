package com.example.demo.services;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


import com.example.demo.entities.Reservation;

public interface IReservationService {
	Reservation insertReservation(Reservation r);
	Reservation updateReservation(int id,Reservation r);
	List<Reservation> selectAll();
	Reservation getReservationById(int id);
	boolean deleteReservation(int id);
	Reservation addFeedback(int id, String f);
	Reservation addRate(int id, int r);
	Reservation resDone(int id);
	Reservation resUndone(int id);
	Reservation resAnnulé(int id);
	List<Reservation> reservationParTerrain(int id);
	List<Reservation> reservationParTerrainEtDate(int id,LocalDateTime d1,LocalDateTime d2);
	List<Reservation> reservationParClient(int id);
	int nombreReservation(Date d) ;

}
