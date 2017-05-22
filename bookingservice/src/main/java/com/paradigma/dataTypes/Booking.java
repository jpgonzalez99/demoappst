package com.paradigma.dataTypes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Booking {

	private String iataOrigin;
	private String iataDestination;
	private String carrier;
	private float price;
	
	Passenger passenger;
}
