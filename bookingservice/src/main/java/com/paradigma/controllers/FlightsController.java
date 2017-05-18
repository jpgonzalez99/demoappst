package com.paradigma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.dto.FlightDetailsDTO;
import com.paradigma.services.FlightService;

@RestController
public class FlightsController {
	
	@Autowired
	FlightService flightService;
	
	
	@RequestMapping("/flightsFrom/{origin}/to/{destination}")
	public List<FlightDetailsDTO> getFlightsDetails(@PathVariable String origin, @PathVariable String destination){
		 return flightService.getFlightDetails(origin,destination);
	}

}
