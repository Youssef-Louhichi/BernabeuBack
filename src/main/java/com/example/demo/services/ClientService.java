package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;

import com.example.demo.repositories.ClientRep;

@Service
public class ClientService implements IClientService{
	
	@Autowired
	private ClientRep cp;

	@Override
	public Client insertClient(Client c) {
		// TODO Auto-generated method stub
		return this.cp.save(c);
	}

	@Override
	public Client updateClient(int id, Client c) {
		Client exClient = cp.findById(id).get();

        if (exClient != null) {
        	
        	exClient.setNom(c.getNom());

        	exClient.setPrenom(c.getPrenom());
        	
        	exClient.setDate_naissance(c.getDate_naissance());
        	exClient.setEmail(c.getEmail());
        	exClient.setTel(c.getTel());
        	
        	

        	

   

        	cp.save(exClient);

        	}

        return exClient;
	}

	@Override
	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		return this.cp.findAll();
	}

	@Override
	public Client getClientById(int id) {
		// TODO Auto-generated method stub
		return this.cp.findById(id).get();
	}
	
	@Override
	public Client getClientByEmailAndMdp(String log,String mdp) {
		// TODO Auto-generated method stub
		return this.cp.findByEmailAndMdp(log,mdp);
	}

	@Override
	public boolean deletClient(int id) {
		if(this.cp.existsById(id)) {
		 this.cp.deleteById(id);
		return true;
		}
		return false;
	}

	@Override
	public Client changerMdp(int id, String m) {
		Client exClient = cp.findById(id).get();

        if (exClient != null) {
        	
        	exClient.setMdp(m);
        	cp.save(exClient);

        	}

        return exClient;
	}

}
