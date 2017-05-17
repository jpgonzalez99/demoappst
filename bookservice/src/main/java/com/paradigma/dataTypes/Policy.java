package com.paradigma.dataTypes;

import java.util.List;

import lombok.Data;

@Data
public class Policy {

	String name;
	String description;
	float defaultPrice;
	List<Service> services;
}
