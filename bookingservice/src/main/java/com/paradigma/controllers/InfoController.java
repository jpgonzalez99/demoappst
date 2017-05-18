package com.paradigma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.dataTypes.Airport;
import com.paradigma.services.InfoService;

@RestController
public class InfoController	 {

	@Autowired
	InfoService infoService;
	
	@RequestMapping("/origins")
	public List<Airport> getOrigins(){
		return infoService.getOrigins();
	}
	
	
	
	@RequestMapping("/destinationsFrom/{origin}")
	public List<Airport> getDestinations(@PathVariable String origin){
		
		return infoService.getDestinationsFrom(origin);
	}
	
}
