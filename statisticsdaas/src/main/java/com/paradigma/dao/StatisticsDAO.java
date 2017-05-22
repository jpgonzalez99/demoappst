package com.paradigma.dao;

import java.util.List;

import com.paradigma.entities.FlightStatistics;

public interface StatisticsDAO {


	 
	 
	 List<FlightStatistics> getFlightstatistics(String origin, String destination);
	 
	 List<FlightStatistics> getFlightstatisticsForCarrier(String origin, String destination,String carrier);
}
