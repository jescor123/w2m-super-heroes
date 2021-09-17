package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.dao.SuperHeroeDAO;
import com.luv2code.springdemo.entity.SuperHeroe;

@Service
public class SuperHeroeServiceImpl implements SuperHeroeService {

	
	@Autowired
	private SuperHeroeDAO superHeroeDAO;
	
	@Override
	@Transactional
	public List<SuperHeroe> getAllSuperHeroes() {
		
		return superHeroeDAO.getAllSuperHeroes();
		
	}

	@Override
	@Transactional
	public List<SuperHeroe> getSuperHeroesByName(String search) {
		
		return superHeroeDAO.getSuperHeroesByName(search);
		
	}

	@Override
	@Transactional
	public void updateSuperHeroe(SuperHeroe superHeroe) {
		
		superHeroeDAO.updateSuperHeroe(superHeroe);
		
	}

	@Override
	@Transactional
	public void deleteSuperHeroe(int id) {
		
		superHeroeDAO.deleteSuperHeroe(id);
		
	}

	@Override
	@Transactional
	public SuperHeroe getSuperHeroeById(int id) {
		
		return superHeroeDAO.getSuperHeroeById(id);
		
	}
	

}
