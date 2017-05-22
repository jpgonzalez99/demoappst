package com.paradigma.services;

import com.paradigma.dto.BookingDetailsDTO;
import com.paradigma.exception.BookingException;




public interface BookingService	 {

	
  void saveBooking(BookingDetailsDTO bookingDetails) throws BookingException;
	
	
}
