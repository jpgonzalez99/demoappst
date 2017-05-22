package com.paradigma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.dto.BookingDetailsDTO;
import com.paradigma.exception.BookingException;
import com.paradigma.services.BookingService;

@RestController
public class BookingController {
	
	
	@Autowired
	BookingService bookService;
	
	
	
	@RequestMapping(path="/saveBooking",method=RequestMethod.POST)
	public ResponseEntity<String> bookFlight(@RequestBody BookingDetailsDTO bookingDetails ){
		
		ResponseEntity<String> result =null;
		try{
			bookService.saveBooking(bookingDetails);
			result = new ResponseEntity<String>("", new HttpHeaders(), HttpStatus.OK); 
		}
		catch(Exception ex){
			ex.printStackTrace();
			result =new ResponseEntity<String>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return result;
	}

}
