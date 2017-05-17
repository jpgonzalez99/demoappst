package com.paradigma.dto;

import java.util.List;

import org.springframework.cloud.netflix.zuul.filters.Route;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RouteResponseDTO {

	List<Route> routes;
	
}
