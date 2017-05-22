package com.paradigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

public abstract  class URLAbstractService {
	
	@Value("${dependencies.routeDaasId}")
	String routeDaasId;
	
	@Value("${dependencies.statisticsDaaSId}")
	String statisticsDaaSId;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String getURL(String id) {
	    List<ServiceInstance> list = discoveryClient.getInstances(id);
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri().toString();
	    }
	    return null;
	}
	
}
