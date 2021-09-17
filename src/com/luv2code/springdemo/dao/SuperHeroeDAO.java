package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.SuperHeroe;

public interface SuperHeroeDAO {
	
	public List<SuperHeroe> getAllSuperHeroes();
	
    public List<SuperHeroe> getSuperHeroesByName(String search);
	
	public void updateSuperHeroe(SuperHeroe superHeroe);
	
	public void deleteSuperHeroe(int id);

	public SuperHeroe getSuperHeroeById(int id);
		
}
