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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.services.IClientService;



@RestController
public class ClientController {
	
	@Autowired
	private IClientService ics;
	
	
	
	
	@GetMapping("/getclients")
	public  List<Client> getClients() {
	
	        return this.ics.selectAll();
	   
	} 
	
	@GetMapping("/getclient")
	public Client login(@RequestParam("login") String log, @RequestParam("pwd") String p) {
	    return this.ics.getClientByEmailAndMdp(log, p);
	    
	}
	
	
	@GetMapping("/getclients/{id}")
	public  ResponseEntity<?> getClientById(@PathVariable("id") int id) {
		try {
	        return ResponseEntity.ok(this.ics.getClientById(id));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucun client qui a l'id " + id );
	    }
	} 
	
	
	
	
	@PostMapping("/addclient")
	public Client ajouter(@RequestBody Client c) {
		return this.ics.insertClient(c);
	}
	
	
	@PutMapping("/updateclient/{id}")
	public ResponseEntity<?> updateClient(@PathVariable("id") int id,@RequestBody Client c) {
		
		
		try {
	        return ResponseEntity.ok(this.ics.updateClient(id,c));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucun client qui a l'id " + id );
	    }
	}
	
	
	@PutMapping("/updatepwd/{id}")
	public ResponseEntity<?> changerPwd(@PathVariable("id") int id,@RequestBody String pwd) {
		try {
	        return ResponseEntity.ok(this.ics.changerMdp(id,pwd));
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il y a aucun client qui a l'id " + id );
	    }
	}
	
	@DeleteMapping("/deleteclient/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") int id) {
	    try {
	        if (this.ics.deletClient(id)) {
	            return ResponseEntity.ok("Suppression réussie");
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la suppression");
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Il n'y a aucun client avec l'ID " + id);
	    }
	}


}


