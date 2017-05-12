package com.paradigma.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paradigma.entities.Route;

@RepositoryRestResource(collectionResourceRel = "flight", path = "flight")
public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {

}
