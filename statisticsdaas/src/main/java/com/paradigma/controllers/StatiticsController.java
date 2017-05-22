package com.paradigma.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.entities.FlightStatistics;
import com.paradigma.services.StatisticsServices;

@RestController
public class StatiticsController {
	
	@Autowired
	StatisticsServices statisticsServices;
	

	
	@RequestMapping("/flightStatisticsFrom/{origin}/to/{destination}/withCarrier/{carrier}")
	List<FlightStatistics> getAllFlightstatisticsForCarrier(@PathVariable String origin, @PathVariable String destination,@PathVariable String carrier){
		return statisticsServices.getAllFlightsFromForCarrier(origin, destination,carrier);
	}
	
	@RequestMapping("/flightStatisticsFrom/{origin}/to/{destination}")
	List<FlightStatistics> getAllFlightstatistics(@PathVariable String origin, @PathVariable String destination){
		return statisticsServices.getAllFlightsFrom(origin, destination);
	}

}
