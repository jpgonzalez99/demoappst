package com.paradigma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BookingDaaSApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingDaaSApplication.class, args);
	}
}
