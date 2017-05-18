package com.paradigma.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigma.entities.Airport;
import com.paradigma.entities.Route;
import com.paradigma.repositories.AirportRepository;
import com.paradigma.repositories.RouteRepository;

@Service
public class RouteServicesDefault implements RouteServices{

	
	@Autowired
	RouteRepository route;
	
	@Autowired
	AirportRepository airport;
	
	public List<Airport> getAirportsConnectedWith(String origin){
		
		List<Airport> result = new ArrayList<Airport>();
		
		Airport originAirport= airport.findByIata(origin); 
		List<Route> routes= route.findByOrigin(originAirport);
		
		result= Arrays.asList((Airport[]) routes.stream()
				                                 .map(a -> a.getDestination())
				                                 .toArray());
		
		return result;
		
	}
	

	@Override
	public List<Airport> getOriginAirports() {
		return route.findOrigins();
	}


}
