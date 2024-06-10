package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Terrain;
import com.example.demo.services.ITerrainService;

@RestController
public class TerrainController {
	
	@Autowired
	private ITerrainService its;
	
	
	@GetMapping("/getterrain/{id}")
	public  ResponseEntity<?> getTerrainById(@PathVariable("id") int id) {
		try {
	        return ResponseEntity.ok(this.its.getTerrain(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucun terrain qui a l'id " + id );
	    }
	} 
	
	
	@GetMapping("/getterrains")
	public List<Terrain>  getTerrains() {
		
        return this.its.selectAll();
   
} 
	
	
	
	@PostMapping("/addterrain")
	public String ajouter(@RequestBody Terrain t) {
		if (t==null) {
			return "objet null";
		}
		if(this.its.InsertTerrain(t)) {
			return "ajouter avec succées";
		}
		return "ajout failed";
	}
	
	@DeleteMapping("/deleteterrain/{id}")
	public ResponseEntity<String> deleteTerrain(@PathVariable("id") int id) {
	    try {
	        if (this.its.deleteTerrain(id)) {
	            return ResponseEntity.ok("Suppression réussie");
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la suppression");
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il n'y a aucun terrain avec l'ID " + id);
	    }
	}
	
	
	@PutMapping("/updateterrain/{id}")
	public ResponseEntity<?> updateTerrain(@PathVariable("id") int id,@RequestBody Terrain t) {
		
		
		try {
	        return ResponseEntity.ok(this.its.updateTerrain(id,t));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucun terrain qui a l'id " + id );
	    }
	}
	
	
	@PutMapping("/terraindispo/{id}")
	public ResponseEntity<?> terrainAvailable(@PathVariable("id") int id) {
		try {
	        return ResponseEntity.ok(this.its.TerrainAvaible(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucun terrain qui a l'id " + id );
	    }
	}
	
	@PutMapping("/terrainindispo/{id}")
	public ResponseEntity<?> terrainUnavailable(@PathVariable("id") int id) {
		try {
	        return ResponseEntity.ok(this.its.TerrainUnavaible(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucun terrain qui a l'id " + id );
	    }
	}

}


