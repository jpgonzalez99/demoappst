package com.paradigma.dto;

import java.util.List;

import com.paradigma.dataTypes.Route;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RouteResponseDTO {

	List<Route> routes;
	
}
