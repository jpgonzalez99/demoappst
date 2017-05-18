package com.paradigma.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.paradigma.dto.FlightDetailsDTO;



@Service
public class FlightServiceDefault	implements FlightService {

	
	
   public List<FlightDetailsDTO> getFlightDetails(String origin, String destination){
	   
	   return generateRandomFlightDetails(15);
   }
   
   
   
   private List<FlightDetailsDTO> generateRandomFlightDetails (int numFlights){
	   
	   String [] carriers = {"Iberia", "British Airways", "Avianca", "Delta", "Aeroflot", "Vueling" , "AirEuropa"};
	   
	   Random random = new Random();
	   List<FlightDetailsDTO> flightDetails = new ArrayList<FlightDetailsDTO>();
	   
	   for(int i=0;i<numFlights;i++){
		   flightDetails.add(FlightDetailsDTO.builder()
				   						   .flightId(i)
				                          .carrier(carriers[random.nextInt(carriers.length)])
				                          .estimatedTime("1h")
				                          .freeSeats(10)
				                          .price(100)
				                          .punctuality(99)
				                          .localArrival(new Date())
				                          .localDeparture(new Date())
				                          .build());
	   }
	   
	   return flightDetails;
   }
	
	
}
