package com.paradigma.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paradigma.entities.Passenger;

@RepositoryRestResource(collectionResourceRel = "passsenger", path = "passsenger")
public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Long> {

}
