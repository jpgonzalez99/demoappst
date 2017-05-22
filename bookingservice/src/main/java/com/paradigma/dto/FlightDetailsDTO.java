package com.paradigma.dto;

import java.util.Date;

import com.paradigma.dataTypes.Airport;
import com.paradigma.dataTypes.Carrier;
import com.paradigma.dataTypes.Plane;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightDetailsDTO {

	
	private long flightId;
	
	private Airport origin;
	private Airport destination;
	private Plane plane;
	private Carrier carrier;
	private float price; 
	
	
	private int  averageFlightDelay;
	private int averageCarrierDelay; 
	
	
}
