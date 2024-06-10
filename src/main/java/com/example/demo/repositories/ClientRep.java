package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Client;

public interface ClientRep extends JpaRepository<Client,Integer>{
	
	@Query("SELECT c FROM Client c WHERE c.email=?1 and c.mdp=?2 ")
	Client findByEmailAndMdp(String log,String mdp);

}
