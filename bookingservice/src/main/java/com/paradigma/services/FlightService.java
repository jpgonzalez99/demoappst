package com.paradigma.services;

import java.util.List;

import com.paradigma.dto.FlightDetailsDTO;




public interface FlightService	 {

	
   List<FlightDetailsDTO> getFlightDetails(String origin,String destination);
	
	
}
