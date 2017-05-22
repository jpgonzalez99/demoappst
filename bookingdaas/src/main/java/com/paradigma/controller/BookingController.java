
package com.paradigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.dto.BookingDetailsDTO;
import com.paradigma.services.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	
	@RequestMapping("/saveBooking")
	public String saveBooking(@RequestBody BookingDetailsDTO booking){
		String result = "OK";
		try{
			bookingService.saveBooking(booking);
		}
		catch(Exception ex){
			ex.printStackTrace();
			result="KO";
		}
		return result;
	}
	

}
