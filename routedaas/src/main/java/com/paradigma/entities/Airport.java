package com.paradigma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;



@Entity
@Data
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long airportId;
	
	private String name;
	private String iata;
	private String city;
	private String country;
	private String state;
	private float latitude;
	private float longitude;
	
		
	
}
