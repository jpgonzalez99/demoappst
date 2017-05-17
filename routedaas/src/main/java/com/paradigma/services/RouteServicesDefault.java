package com.paradigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigma.entities.Route;
import com.paradigma.repositories.RouteRepository;

@Service
public class RouteServicesDefault implements RouteServices{

	
	@Autowired
	RouteRepository route;
	
	public List<Route> getRoutesFrom(String origin){
		
		return route.findByOrigin(origin);
	}
	
  public List<Route> getRoutesTo(String destination){
	  return route.findByDestination(destination);
	}

@Override
public List<String> getOrigins() {
	return route.findOrigins();
}
}
