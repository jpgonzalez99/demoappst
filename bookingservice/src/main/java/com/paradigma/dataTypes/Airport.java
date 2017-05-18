package com.paradigma.dataTypes;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;




@Data
public class Airport {
	
	
	@JsonIgnore
	private long airportId;
	
	@JsonProperty("iataCode")
	private String iatacode;
	
	private String name;
	private String city;
	private String state;
	private String country;
	
	private float latitude;
	private float longitude;
		
	
}
