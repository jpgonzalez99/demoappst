package com.paradigma.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Route {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long routeId;

	private String origin;
	private String destination;
    private  LocalDateTime inaugurationDate;
    private Plane plane; 
    private List<String> flightsCode;
	
	
}
