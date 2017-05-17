package com.paradigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paradigma.dataTypes.Policy;
import com.paradigma.dto.RouteResponseDTO;

@Service
public class InfoServiceDefault	implements InfoService {

	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String routeURL() {
	    List<ServiceInstance> list = discoveryClient.getInstances("routedaaS");
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri().toString();
	    }
	    return null;
	}
	
	
	


	@Override
	public List<Route> getOrigins() {
		 RestTemplate restTemplate = new RestTemplate();		 
		 RouteResponseDTO response= restTemplate.getForObject(routeURL()+"/route",  RouteResponseDTO.class);
		
		 return response.getRoutes();
		
		
	}


	@Override
	public List<Policy> getDestinations() {
		// TODO Auto-generated method stub
		return null;
	}
		  
	
	
}
