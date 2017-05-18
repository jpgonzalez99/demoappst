package com.paradigma.services;

import java.util.List;

import com.paradigma.dataTypes.Airport;




public interface InfoService	 {

	
   List<Airport> getOrigins();
   List<Airport> getDestinationsFrom(String origin);
	
	
}
