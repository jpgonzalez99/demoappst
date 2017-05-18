package com.paradigma.dataTypes;

import lombok.Data;




@Data
public class Airport {
	

	private long airportId;
	private String name;
	private String iata;
	private String city;
	private String country;
	private String state;
	private float latitude;
	private float longitude;
	
		
	
}
