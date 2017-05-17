package com.paradigma.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.dataTypes.Route;
import com.paradigma.services.InfoService;

@RestController
public class InfoController	 {

	@Autowired
	InfoService infoService;
	
	@RequestMapping({"/origin/{destination}" , "/origin"})
	public List<String> getOrigins(@PathVariable  Optional<String> destination){
		
		return infoService.getOrigins();
	}
	
	

	
	
	@RequestMapping("/destination/{origin}")
	public List<Route> getDestinations(@PathVariable String origin){
		
		return infoService.getDestinations();
	}
	
}
