package com.paradigma.services;

import java.util.List;

import com.paradigma.dto.FlightDetails;




public interface FlightService	 {

	
   List<FlightDetails> getFlightDetails(String origin,String destination);
	
	
}
