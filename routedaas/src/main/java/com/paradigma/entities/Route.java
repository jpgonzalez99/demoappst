package com.paradigma.entities;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class Route {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long routeId;

	@ManyToOne
	private Airport origin;
	@ManyToOne
	private Airport destination;
	
	
    private  Date inaugurationDate;
    
    @ManyToOne
    private Plane plane; 

       
    
   // @OneToMany(targetEntity=String.class,fetch=FetchType.LAZY)
    private HashSet<String> flightsCode;
	
	
}
