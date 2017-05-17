package com.paradigma.services;

import java.util.List;

import com.paradigma.dataTypes.Route;




public interface InfoService	 {

	
   List<String> getOrigins();
   List<Route> getDestinations();
	
	
}
