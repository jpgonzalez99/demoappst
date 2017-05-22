package com.paradigma.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paradigma.entities.Booking;


public interface BookingRepository extends PagingAndSortingRepository<Booking, Long> {
	

	
}
