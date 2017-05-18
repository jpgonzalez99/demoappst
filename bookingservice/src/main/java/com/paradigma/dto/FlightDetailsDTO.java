package com.paradigma.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightDetailsDTO {

	
	private long flightId;
	
	private String carrier;
	private String estimatedTime;
	private float punctuality; 
	private float price; 
	private int freeSeats;
	private Date localDeparture;
	private Date localArrival;
	
}
