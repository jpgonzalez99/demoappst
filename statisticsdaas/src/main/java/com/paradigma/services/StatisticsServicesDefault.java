package com.paradigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigma.dao.StatisticsDAO;
import com.paradigma.entities.FlightStatistics;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StatisticsServicesDefault implements StatisticsServices{

	
	@Autowired
	StatisticsDAO allflights;
	

	@Override
	public List<FlightStatistics> getAllFlightsFrom(String origin, String destination) {
		return allflights.getFlightstatistics(origin, destination);
	}


	@Override
	public List<FlightStatistics> getAllFlightsFromForCarrier(String origin, String destination, String carrier) {
		return allflights.getFlightstatisticsForCarrier(origin, destination, carrier);
	}


}
