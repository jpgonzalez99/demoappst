package com.paradigma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;



@Entity
@Data
@Table(name="airports")
public class Airport {
	
	@Id	
	@Column(name="iata")
	@JsonProperty("iataCode")
	private String iata;
	
	@Column(name="airport")
	private String name;
	private String city;
	private String state;
	private String country;
	
	private float latitude;
	private float longitude;
	

}
