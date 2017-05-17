package com.paradigma.services;

import java.util.List;

import org.springframework.cloud.netflix.zuul.filters.Route;


public interface InfoService	 {

	
   List<Route> getOrigins();
   List<Route> getDestinations();
	
	
}
