package com.paradigma.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paradigma.dataTypes.Airport;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InfoServiceDefault	extends RouteDaaSAbstractService implements InfoService  {

	
	

	@Override
	public List<Airport> getOrigins() {
	 
		 List<Airport> result = new ArrayList<Airport>();
		 String routeDaaSUrl = routeDaaSUrl();
		 
		 if(routeDaaSUrl!=null){
			
			 log.debug("RouteDaaSurl ",routeDaaSUrl);
			 
			 ResponseEntity<Airport[]> origins = restTemplate.getForEntity(routeDaaSUrl+"/originAirports",  Airport[].class);
			 result= Arrays.asList(origins.getBody());
		 }
		 else {
			 log.error("The routeDaasUrl doesn't exist");
			 
		 }
		 
		 return result;
		
	}


	@Override
	public List<Airport> getDestinationsFrom(String origin) {
		
		List<Airport> result = new ArrayList<Airport>();
		String routeDaaSUrl = routeDaaSUrl();
		
		 if(routeDaaSUrl!=null){
				
			 log.debug("RouteDaaSurl ",routeDaaSUrl);
			 
			 ResponseEntity<Airport[]> origins = restTemplate.getForEntity(routeDaaSUrl+"/airportsConnectedWith/" + origin,  Airport[].class);
			 result= Arrays.asList(origins.getBody());
		 }
		 else {
			 log.error("The routeDaasUrl doesn't exist");
			 
		 }
		 
		 return result;
	}
		  
	
	
}
