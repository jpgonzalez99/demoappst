package com.paradigma.dataTypes;

import lombok.Builder;
import lombok.Data;


@Data
public class FlightAverage {

	private float averageFlightDelay;
	private float averageCarrierDelay;
}
