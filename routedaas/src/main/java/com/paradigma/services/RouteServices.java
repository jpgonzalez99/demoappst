package com.paradigma.services;

import java.util.List;

import com.paradigma.entities.Airport;
import com.paradigma.entities.Route;


public interface RouteServices {

	
	List<Airport> getAirportsConnectedWith(String origin);
		
	
  
    List<Airport> getOriginAirports();
    
    List<Route> getAllRoutes(String origin,String destination);
		
}
