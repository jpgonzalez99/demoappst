package com.paradigma.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paradigma.dataTypes.FlightAverage;
import com.paradigma.dataTypes.FlightStatistics;
import com.paradigma.dataTypes.Route;
import com.paradigma.dto.FlightDetailsDTO;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class FlightServiceDefault	extends URLAbstractService implements FlightService {

	
	/**
	 * The available flights will be the routes + extra info
	 */
   public List<FlightDetailsDTO> getFlightDetails(String origin, String destination){
	   
   
	     List<FlightDetailsDTO> result = new ArrayList<FlightDetailsDTO>();
	     Random random = new Random();
		 String routeDaaSUrl = getURL(routeDaasId);
		 
		 if(routeDaaSUrl!=null){
			
			 log.debug("RouteDaaSurl ",routeDaaSUrl);
			 String urlRouteDaas = new StringBuilder().append(routeDaaSUrl)
					 						 .append("/routesFrom/")
					 						 .append(origin)
					 						 .append("/to/")
					 						 .append(destination)
					 						 .toString();
			 
			 ResponseEntity<Route[]> origins = restTemplate.getForEntity(urlRouteDaas,  Route[].class);
			 List<Route> routes=Arrays.asList(origins.getBody());
			
			 result=routes.stream().map(a -> {
				 
				 				 String statisticsDaaSUrl = getURL(statisticsDaaSId);
				 				
								 
				 				 if(statisticsDaaSUrl!=null){
									 String urlStatisticsDaas = new StringBuilder().append(statisticsDaaSUrl)
											 .append("/flightStatisticsFrom/")
											 .append(origin)
											 .append("/to/")
											 .append(destination)
											 .append("/withCarrier/")
											 .append(a.getCarrier().getCode())
											 .toString();
									//Finally we collect the statistics 
									 ResponseEntity<FlightStatistics[]> statistics = restTemplate.getForEntity(urlStatisticsDaas,  FlightStatistics[].class);
				 				 
									 
									 int sumFlightDelay=0;
									 int sumCarrierDelay=0;
									 int numFlights=0;
							
									
									 for (FlightStatistics flight:statistics.getBody() ){
										 numFlights++;
										 sumFlightDelay+= Integer.valueOf(flight.getDepdelay())+Integer.valueOf(flight.getArrdelay()) ;
										 sumCarrierDelay+= Integer.valueOf(flight.getCarrierdelay());
									 }
				 				 
				                 return FlightDetailsDTO.builder()
				                		                .flightId(a.getRouteId())
				                		                .carrier(a.getCarrier())
				                		                .origin(a.getOrigin())
				                		                .destination(a.getDestination())
				                		                .plane(a.getPlane())
				                		                .price(210 + random.nextFloat()*150)
				                		                .averageCarrierDelay((numFlights==0)?0:sumCarrierDelay/numFlights)
				                		                .averageFlightDelay((numFlights==0)?0:sumFlightDelay/numFlights)
				                		                .build();      		                
				 				 }
				 				 else {
				 				
				 					  return FlightDetailsDTO.builder()
		                		                .flightId(a.getRouteId())
		                		                .carrier(a.getCarrier())
		                		                .origin(a.getOrigin())
		                		                .destination(a.getDestination())
		                		                .plane(a.getPlane())
		                		                .price(210 + random.nextFloat()*150)		                		         
		                		                .build();   
				 				 }
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
