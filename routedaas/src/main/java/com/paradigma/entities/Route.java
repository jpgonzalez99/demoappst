package com.paradigma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="routes")
public class Route {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long routeId;

	@ManyToOne
	private Airport origin;
	@ManyToOne
	private Airport destination;
	
	@ManyToOne
	private Carrier carrier;
	
    
    @ManyToOne
    private Plane plane; 

       

	
}
