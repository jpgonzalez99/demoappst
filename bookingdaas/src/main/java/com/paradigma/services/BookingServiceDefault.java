package com.paradigma.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigma.dto.BookingDetailsDTO;
import com.paradigma.entities.Passenger;
import com.paradigma.repositories.BookingRepository;
import com.paradigma.repositories.PassengerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingServiceDefault implements BookingService{
   
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	public void saveBooking(BookingDetailsDTO booking){
		
		
		Optional<Passenger> passenger=passengerRepository.findByDni(booking.getBooking().getPassenger().getDni());
		
		if(passenger.isPresent()){
			Passenger passengerDB = passenger.get();
			
			if(!passengerDB.getFirstName().equals(booking.getBooking().getPassenger().getFirstName()) || 
			   !passengerDB.getGender().equals(booking.getBooking().getPassenger().getGender()) ||
			   !passengerDB.getLastName().equals(booking.getBooking().getPassenger().getLastName()))
				
				log.error("Passenger DNI {} already exists with different data", passengerDB.getDni() );
			
		}else {
			passengerRepository.save(booking.getBooking().getPassenger());
		}
		
		bookingRepository.save(booking.getBooking());
		
	}
}
