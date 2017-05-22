package com.paradigma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Booking {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
	private String iataOrigin;
	private String iataDestination;
	private String carrier;
	private float price;

	
	@OneToOne
	private Passenger passenger;
       

	
}
