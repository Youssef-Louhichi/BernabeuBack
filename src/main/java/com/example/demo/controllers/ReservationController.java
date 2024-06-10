package com.example.demo.controllers;

 
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Reservation;
import com.example.demo.services.IReservationService;


@RestController
public class ReservationController {
	
	@Autowired
	private IReservationService irs;
	
	
	@GetMapping("/getreservation/{id}")
	public  ResponseEntity<?> getReservationById(@PathVariable("id") int id) {
		try {
	        return ResponseEntity.ok(this.irs.getReservationById(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucune reservation qui a l'id " + id );
	    }
	} 
	
	@GetMapping("/getreservations")
	public List<Reservation>  getReservations() {
		
        return this.irs.selectAll();
   
} 
	
	@GetMapping("/getreservationterrain/{id}")
	public List<Reservation> getReservationByTerrain(@PathVariable("id") int id) {
		return this.irs.reservationParTerrain(id);
	  
	} 
	
	@GetMapping("/getreservationterrainetdate")
	public List<Reservation> getReservationByTerrainEtDate(
		    @RequestParam("id") int id,
		    @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d1,
		    @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d2) {
		return this.irs.reservationParTerrainEtDate(id,d1,d2);
	  
	} 
	
	@GetMapping("/getreservationclient/{id}")
	public List<Reservation> getReservationByClient(@PathVariable("id") int id) {
		return this.irs.reservationParClient(id);
	  
	} 
	
	@GetMapping("/nombrereservation")
	public int nbResParDate(@RequestBody Date d) {
		return this.irs.nombreReservation(d);
	  
	} 
	
	
	
	
	@PostMapping("/addreservation")
	public boolean ajouter(@RequestBody Reservation r) {
		return this.irs.insertReservation(r);
	}
	
	@PutMapping("/addfeedback/{id}")
	public ResponseEntity<?> addFeedback(@PathVariable("id") int id,@RequestBody String f) {
		try {
	        return ResponseEntity.ok(this.irs.addFeedback(id,f));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucune reservation qui a l'id " + id );
	    }
	}
	
	@PutMapping("/addrate/{id}")
	public ResponseEntity<?> addRate(@PathVariable("id") int id,@RequestBody int r) {
		try {
	        return ResponseEntity.ok(this.irs.addRate(id,r));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucune reservation qui a l'id " + id );
	    }
	}
	
	@PutMapping("/annuleeres/{id}")
	public ResponseEntity<?> annuléReservation(@PathVariable("id") int id){
		try {
	        return ResponseEntity.ok(this.irs.resAnnulé(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucune reservation qui a l'id " + id );
	    }
	}
	
	
	@DeleteMapping("/deletereservation/{id}")
	public ResponseEntity<String> deleteRes(@PathVariable("id") int id) {
	    try {
	        if (this.irs.deleteReservation(id)) {
	            return ResponseEntity.ok("Suppression réussie");
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la suppression");
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il n'y a aucune reservation avec l'ID " + id);
	    }
	}
	
	
	@PutMapping("/updatereservation/{id}")
	public ResponseEntity<?> updateRes(@PathVariable("id") int id,@RequestBody Reservation r) {
		
		
		try {
	        return ResponseEntity.ok(this.irs.updateReservation(id,r));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucune reservation qui a l'id " + id );
	    }
	}
	
	@PutMapping("/reservationdone/{id}")
	public ResponseEntity<?> makeDone(@PathVariable("id") int id) {
		try {
	        return ResponseEntity.ok(this.irs.resDone(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucune reservation qui a l'id " + id );
	    }
	}
	
	@PutMapping("/reservationundone/{id}")
	public ResponseEntity<?> makeUndone(@PathVariable("id") int id) {
		try {
	        return ResponseEntity.ok(this.irs.resUndone(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucune reservation qui a l'id " + id );
	    }
	}


}


