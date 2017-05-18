package com.paradigma.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paradigma.dataTypes.Route;
import com.paradigma.dto.FlightDetailsDTO;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class FlightServiceDefault	extends RouteDaaSAbstractService implements FlightService {

	
	/**
	 * The available flights will be the routes + extra info
	 */
   public List<FlightDetailsDTO> getFlightDetails(String origin, String destination){
	   
   
	     List<FlightDetailsDTO> result = new ArrayList<FlightDetailsDTO>();
	     Random random = new Random();
		 String routeDaaSUrl = routeDaaSUrl();
		 
		 if(routeDaaSUrl!=null){
			
			 log.debug("RouteDaaSurl ",routeDaaSUrl);
			 String url = new StringBuilder().append(routeDaaSUrl)
					 						 .append("/routesFrom/")
					 						 .append(origin)
					 						 .append("/to/")
					 						 .append(destination)
					 						 .toString();
			 
			 ResponseEntity<Route[]> origins = restTemplate.getForEntity(url,  Route[].class);
			 List<Route> routes=Arrays.asList(origins.getBody());
			 
			 result=routes.stream().map(a -> {
				                 return FlightDetailsDTO.builder()
				                		                .carrier(a.getCarrier())
				                		                .origin(a.getOrigin())
				                		                .destination(a.getDestination())
				                		                .plane(a.getPlane())
				                		                .price(210 + random.nextFloat()*150)
				                		                .build();      		                
				                		     
			                     })
			                      .collect(Collectors.toList());
			 
			 
		 }
		 else {
			 log.error("The routeDaasUrl doesn't exist");
			 
		 }
		 
		 
		  return result;
   }
   
   
   /*
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
   */
	
	
}
