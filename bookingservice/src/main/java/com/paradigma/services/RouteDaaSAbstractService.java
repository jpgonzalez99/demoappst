package com.paradigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

public abstract  class RouteDaaSAbstractService {
	
	@Value("${dependencies.routeDaasId}")
	String routeDaasId;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String routeDaaSUrl() {
	    List<ServiceInstance> list = discoveryClient.getInstances(routeDaasId);
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri().toString();
	    }
	    return null;
	}
	
}
