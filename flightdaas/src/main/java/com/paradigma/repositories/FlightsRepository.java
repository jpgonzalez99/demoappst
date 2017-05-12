package com.paradigma.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paradigma.entities.Flight;

@RepositoryRestResource(collectionResourceRel = "flight", path = "flight")
public interface FlightsRepository extends PagingAndSortingRepository<Flight, Long> {

}
