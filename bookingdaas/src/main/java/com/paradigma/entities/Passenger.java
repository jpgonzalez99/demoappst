package com.paradigma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Passenger {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long passengerId;
	

	private String firstName;
	private String lastName;
	private String dni;
	private String gender;
	private String address;
	private String city;
	private long postalCode;
	private String phoneNumber;

	
       

    	
}

	
	

