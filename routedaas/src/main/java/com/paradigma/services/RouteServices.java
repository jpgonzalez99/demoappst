package com.paradigma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paradigma.entities.Route;


public interface RouteServices {

	
	List<Route> getRoutesFrom(String origin);
		
	
  List<Route> getRoutesTo(String destination);
  
  List<String> getOrigins();
		
}
