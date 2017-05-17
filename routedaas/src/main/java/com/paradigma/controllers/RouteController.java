package com.paradigma.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.entities.Route;
import com.paradigma.services.RouteServices;

@RestController
public class RouteController {
	
	@Autowired
	RouteServices routeServices;
	
	@RequestMapping("/routesFrom/{origin}")
	List<Route> getRouteFrom (@PathVariable String  origin){
		
		return routeServices.getRoutesFrom(origin);
	}
	
	@RequestMapping("/routesTo/{destination}")
	List<Route> getRouteTo (@PathVariable String destination){
		return routeServices.getRoutesTo(destination);
	}
	
	@RequestMapping("/origins")
	List<String> getAllOrigins ()
	{
		return routeServices.getOrigins();
	}
	
	

}
