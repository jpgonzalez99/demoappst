package com.paradigma.services;

import java.util.List;

import com.paradigma.entities.Airport;


public interface RouteServices {

	
	List<Airport> getAirportsConnectedWith(String origin);
		
	
  
    List<Airport> getOriginAirports();
		
}
