package com.paradigma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.dataTypes.Policy;
import com.paradigma.services.InfoService;

@RestController
public class InfoController	 {

	@Autowired
	InfoService infoService;
	
	@RequestMapping("/origin/{destination}")
	public List<Policy> getOrigins(@PathVariable String destination){
		
		return infoService.getOrigins();
	}

	
	
	@RequestMapping("/destination/{origin}")
	public List<Policy> getDestinations(@PathVariable String origin){
		
		return infoService.getDestinations();
	}
	
}
