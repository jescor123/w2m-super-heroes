package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springdemo.entity.SuperHeroe;
import com.luv2code.springdemo.service.SuperHeroeService;

import exception.ResourceNotFoundException;

@RestController
@RequestMapping("/superheroes")
public class SuperHeroeController {
	
	@Autowired
	private SuperHeroeService superHeroeService;
		
	// get list of all SuperHeroes	
	@GetMapping("/list")
	List<SuperHeroe> showListAllSuperHeroes() throws ResourceNotFoundException {

		List<SuperHeroe> superHeroes = new ArrayList<>();		
		superHeroes = superHeroeService.getAllSuperHeroes();		
		if(superHeroes.isEmpty()) {
		   throw new ResourceNotFoundException("List SuperHeroe is null : SuperHeroes not found in database");
			
		} 		
		return superHeroes;

	}          
	
	
	// get list of all SuperHeroes by name
	@GetMapping("/listByName/{search}")
	List<SuperHeroe> showListAllSuperHeroesByName(@PathVariable String search) throws ResourceNotFoundException {

		List<SuperHeroe> superHeroes = new ArrayList<>();		
		superHeroes = superHeroeService.getSuperHeroesByName(search);
		if(superHeroes.isEmpty()) {
			throw new ResourceNotFoundException("List of SuperHeroes is null : by name not found in database");

		} 
		return superHeroes;

	}  
	
	
	// add mapping to UPDATE SuperHeroe
	@GetMapping("/updateSuperHeroe/{id}/{name}")
	public ResponseEntity < SuperHeroe > updateSuperHeroe(@PathVariable int id, @PathVariable String name) {

		SuperHeroe superHeroe = new SuperHeroe(id, name);			
		superHeroeService.updateSuperHeroe(superHeroe);	
		System.out.println("SuperHeroe updated");
        return ResponseEntity.ok(superHeroe);		

	}


	// add mapping to DELETE SuperHeroe
	@GetMapping("/delete/{id}")
	public void deleteSuperHeroe(@PathVariable int id) {

		superHeroeService.deleteSuperHeroe(id);		
		System.out.println("SuperHeroe deleted");

	}
	
	
	// add mapping to GET SuperHeroe BY ID
	@GetMapping("/getSuperHeroe/{id}")
	public ResponseEntity < SuperHeroe > getSuperHeroeById(@PathVariable int id) throws ResourceNotFoundException {

		SuperHeroe s = superHeroeService.getSuperHeroeById(id);
		if(s == null) {
			throw new ResourceNotFoundException("Object SuperHeroe is null : SuperHeroe not found in database");

		}
		return ResponseEntity.ok().body(s);
		
	}
	
}
