package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Client;

public interface IClientService {
	
	Client insertClient(Client c);
	Client updateClient(int id,Client c);
	List<Client> selectAll();
	Client getClientById(int id);
	boolean deletClient(int id);
	Client changerMdp(int id,String m);
	Client getClientByEmailAndMdp(String log,String mdp);

}
