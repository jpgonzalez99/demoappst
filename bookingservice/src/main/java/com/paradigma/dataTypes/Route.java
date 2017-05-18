package com.paradigma.dataTypes;

import lombok.Data;


@Data
public class Route {

	
	private long routeId;

	private Airport origin;
	private Airport destination;
	
	
    private  Carrier carrier;
    
 
    private Plane plane; 

       

    	
}

	
	

