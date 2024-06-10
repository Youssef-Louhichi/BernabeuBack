package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Terrain;
import com.example.demo.repositories.TerrainRep;



@Service
public class TerrainService implements ITerrainService{
	
	@Autowired
	private TerrainRep tp;

	@Override
	public boolean InsertTerrain(Terrain t) {
		
		return this.tp.save(t) != null;
	}

	@Override
	public Terrain updateTerrain(int id,Terrain t) {
		Terrain exTerrain = tp.findById(id).get();

        if (exTerrain != null) {
        	exTerrain.setLongeur(t.getLongeur());

        	exTerrain.setLargeur(t.getLargeur());

        	exTerrain.setPrix(t.getPrix());
        	
        	exTerrain.setType(t.getType());
        	

        	

   

        	tp.save(exTerrain);

        	}

        return exTerrain;
	}

	@Override
	public boolean deleteTerrain(int id) {
		if(this.tp.existsById(id)) {
			 this.tp.deleteById(id);
			return true;
			}
			return false;
		
	}

	@Override
	public Terrain TerrainAvaible(int id) {
		Terrain t = tp.findById(id).get();

        if (t != null) {
        	t.setDispo(true);
        }
        return t;
	}

	@Override
	public Terrain TerrainUnavaible(int id) {
		Terrain t = tp.findById(id).get();

        if (t != null) {
        	t.setDispo(false);
        }
        return t;
	}

	@Override
	public List<Terrain> selectAll() {
		return this.tp.findAll();
	}

	@Override
	public Terrain getTerrain(int id) {
		return tp.findById(id).get();
	}

}
