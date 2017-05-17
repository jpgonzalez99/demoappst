package com.paradigma.dataTypes;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data

public class Route {

	
	private long routeId;

	private String origin;
	private String destination;
	
	
    private  Date inaugurationDate;
    
 
    private Plane plane; 

       
    

    private HashSet<String> flightsCode;
	
	
}
