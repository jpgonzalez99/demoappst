package com.paradigma.dto;

import com.paradigma.dataTypes.Client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDetailsDTO {

	

	private FlightDetailsDTO flightDetails;
	private Client client;
	
	
	
	
}
