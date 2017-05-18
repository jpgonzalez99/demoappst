package com.paradigma.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.paradigma.entities.Airport;

public interface AirportRepository extends PagingAndSortingRepository<Airport, Long> {
	
	public Airport findByIata(String iata);
	
}
