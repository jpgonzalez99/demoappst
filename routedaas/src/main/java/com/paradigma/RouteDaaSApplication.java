package com.paradigma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RouteDaaSApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteDaaSApplication.class, args);
	}
	
}
