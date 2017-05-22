package com.paradigma.dataTypes;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class FlightStatistics {

	private int year;
	private String uniquecarrier;
	private int flightnum;
	private int airtime;
	private int arrdelay;
	private int depdelay;
	private String origin;
	private String dest;
	private int distance;
	private String cancelled;
	private String cancellationcode;
	private String diverted;
	private String carrierdelay;
	private String weatherdelay;
	private String nasdelay;
	private String securitydelay;
	private String lateaircraftdelay;

}
