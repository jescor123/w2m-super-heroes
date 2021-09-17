package com.luv2code.springdemo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class HomeController {

	@GetMapping("/startH2")
	public void startAppH2Bd() {
				
		System.out.println("initializing system ...");
		System.out.println("loading H2 database ...");

		String user = "sa";
		String pass = "";

		String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
		String driver = "org.h2.Driver";

		// get connection to database
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			Statement stmt = myConn.createStatement();						
			
			String sqlTable1 = "DROP TABLE SUPERHEROE IF EXISTS; CREATE TABLE SUPERHEROE" +
	                   "(id NUMBER not NULL, " +
	                   " name VARCHAR(255), " +
	                   " PRIMARY KEY ( id ))"; 
	        stmt.executeUpdate(sqlTable1);	        
	       	        
	        String sqlInserts = "INSERT INTO SUPERHEROE (id, name) VALUES (1, 'Superman');"
	        		+ " INSERT INTO SUPERHEROE (id, name) VALUES (2, 'Spiderman');" 
	        		+ " INSERT INTO SUPERHEROE (id, name) VALUES (3, 'Wolverine');" 
	        		+ " INSERT INTO SUPERHEROE (id, name) VALUES (4, 'Hulk');"
	        		+ " INSERT INTO SUPERHEROE (id, name) VALUES (5, 'Manolito el fuerte');"; 

	        stmt.executeUpdate(sqlInserts);
	        
			
			System.out.println("DATA PROCESSED SUCCESSFULLY!!!");
			
			myConn.close();

		}
		catch (Exception exc) {
			exc.getMessage();
			
		}
		
	}
	
}
