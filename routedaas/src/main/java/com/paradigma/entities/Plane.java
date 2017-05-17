package com.paradigma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long planeId;
	
	private int seats;
	private String manufacturer;
	private String model;
	
		
	
}
