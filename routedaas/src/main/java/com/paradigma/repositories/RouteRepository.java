package com.paradigma.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paradigma.entities.Route;

@RepositoryRestResource(collectionResourceRel = "routes", path = "routes")
public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {
	
	List<Route> findByOrigin(String origin);
	
	List<Route> findByDestination(String destination);

}
