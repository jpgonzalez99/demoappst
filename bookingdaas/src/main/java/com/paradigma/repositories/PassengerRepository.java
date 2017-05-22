package com.paradigma.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.paradigma.entities.Passenger;


public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Long> {
	

	Optional<Passenger> findByDni(String dni);
	
}
