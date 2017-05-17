package com.paradigma.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paradigma.dataTypes.Route;

@Service
public class InfoServiceDefault	implements InfoService {

	@Value("${dependencies.routeDaasId}")
	String routeDaasId;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String routeURL() {
	    List<ServiceInstance> list = discoveryClient.getInstances(routeDaasId);
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri().toString();
	    }
	    return null;
	}
	
	
	


	@Override
	public List<String> getOrigins() {
		 RestTemplate restTemplate = new RestTemplate();
		 
		 String routeURL = routeURL();
		 ResponseEntity<String[]> origins = restTemplate.getForEntity(routeURL+"/origins",  String[].class);
	
		 return Arrays.asList(origins.getBody());
		
		
	}


	@Override
	public List<Route> getDestinations() {
		// TODO Auto-generated method stub
		return null;
	}
		  
	
	
}
