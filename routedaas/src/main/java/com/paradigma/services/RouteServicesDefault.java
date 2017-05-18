package com.paradigma.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigma.entities.Airport;
import com.paradigma.entities.Route;
import com.paradigma.repositories.AirportRepository;
import com.paradigma.repositories.RouteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RouteServicesDefault implements RouteServices{

	
	@Autowired
	RouteRepository route;
	
	@Autowired
	AirportRepository airport;
	
	public List<Airport> getAirportsConnectedWith(String origin){
		
		List<Airport> result = new ArrayList<Airport>();
		
		Airport originAirport= airport.findByIata(origin);
		
		if(originAirport!=null){
			
			List<Route> routes= route.findByOrigin(originAirport);
			result= routes
					 .stream()
		             .map(a -> a.getDestination())
		             .collect(Collectors.toList());
		}
		else {
			log.error("The airport {} doesn't exist",origin );
		}
		
		return  result;
		
		
		
	}
	

	@Override
	public List<Airport> getOriginAirports() {
		return route.findOrigins();
	}


}
