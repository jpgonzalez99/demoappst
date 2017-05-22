package com.paradigma.services;

import java.util.List;

import com.paradigma.entities.FlightStatistics;


public interface StatisticsServices {

	
    
    List<FlightStatistics> getAllFlightsFrom(String origin,String destination);
    
    List<FlightStatistics> getAllFlightsFromForCarrier(String origin,String destination,String carrier);
		
}
