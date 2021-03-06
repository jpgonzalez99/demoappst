package com.paradigma.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Flight {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long flightId;

	private Route route;
	private Date date;
	
	
	//List with seats and passengers
	Set<Passenger> occupancy;
	
	
}
