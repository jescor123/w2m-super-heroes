package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springdemo.entity.SuperHeroe;
import com.luv2code.springdemo.service.SuperHeroeService;

@RestController
@RequestMapping("/superheroes")
public class SuperHeroeController {
	
	@Autowired
	private SuperHeroeService superHeroeService;
		
	// get list of all SuperHeroes	
	@GetMapping(value= "/list", produces= "application/vnd.jcg.api.v1+json")
	List<SuperHeroe> showListAllSuperHeroes(){

		List<SuperHeroe> superHeroes = new ArrayList<>();
		
		superHeroes = superHeroeService.getAllSuperHeroes();

		return superHeroes;

	}          
	
	
	// get list of all SuperHeroes by name
	@GetMapping(value= "/listByName/{search}", produces= "application/vnd.jcg.api.v1+json")
	List<SuperHeroe> showListAllSuperHeroesByName(@PathVariable String search){

		List<SuperHeroe> superHeroes = new ArrayList<>();
		
		superHeroes = superHeroeService.getSuperHeroesByName(search);

		return superHeroes;

	}  
	
	
	// add mapping to UPDATE SuperHeroe
	@GetMapping("/updateSuperHeroe/{id}/{name}")
	public void updateSuperHeroe(@PathVariable int id, @PathVariable String name) {

		SuperHeroe superHeroe = new SuperHeroe(id, name);		
		superHeroeService.updateSuperHeroe(superHeroe);		
		System.out.println("SuperHeroe updated");

	}


	// add mapping to DELETE SuperHeroe
	@GetMapping("/delete/{id}")
	public void deleteSuperHeroe(@PathVariable int id) {

		superHeroeService.deleteSuperHeroe(id);		
		System.out.println("SuperHeroe deleted");

	}
	
	
	// add mapping to GET SuperHeroe BY ID
	@GetMapping(value= "/getSuperHeroe/{id}", produces= "application/vnd.jcg.api.v1+json")
	public SuperHeroe getSuperHeroeById(@PathVariable int id) {

		return superHeroeService.getSuperHeroeById(id);		
		
	}
	
}
