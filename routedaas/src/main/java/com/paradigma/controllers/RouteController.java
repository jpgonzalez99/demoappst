package com.paradigma.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.entities.Airport;
import com.paradigma.services.RouteServices;

@RestController
public class RouteController {
	
	@Autowired
	RouteServices routeServices;
	
	@RequestMapping("/airportsConnectedWith/{originAirport}")
	List<Airport> getAirportsConnectedWith (@PathVariable String  originAirport){
		
		return routeServices.getAirportsConnectedWith(originAirport);
	}
	
	
	@RequestMapping("/originAirports")
	List<Airport> getOriginAirports ()
	{
		return routeServices.getOriginAirports();
	}
	
	

}
