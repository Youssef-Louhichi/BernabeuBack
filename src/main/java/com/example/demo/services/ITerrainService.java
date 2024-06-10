package com.example.demo.services;

import java.util.List;


import com.example.demo.entities.Terrain;

public interface ITerrainService {
	
	 boolean InsertTerrain(Terrain t);
	 Terrain updateTerrain(int id,Terrain t);
	 boolean deleteTerrain(int id);
	 Terrain TerrainAvaible(int id);
	 Terrain TerrainUnavaible(int id);
	 List<Terrain> selectAll();
	 Terrain getTerrain(int id);
	

}
