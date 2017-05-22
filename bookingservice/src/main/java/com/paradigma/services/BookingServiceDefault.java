package com.paradigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paradigma.dataTypes.Passenger;
import com.paradigma.dto.BookingDetailsDTO;
import com.paradigma.exception.BookingException;



@Service
public class BookingServiceDefault implements BookingService	 {

	@Value("${dependencies.bookingDaasId}")
	String bookingDaasId;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String bookingDaaSUrl() {
	    List<ServiceInstance> list = discoveryClient.getInstances(bookingDaasId);
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri().toString();
	    }
	    return null;
	}
	
	
  public void saveBooking(BookingDetailsDTO bookingDetails) throws BookingException{
	  
	  validate(bookingDetails);
		 
	  String bookingDaaSUrl = bookingDaaSUrl();
	
	 

	  
	  restTemplate.postForEntity(bookingDaaSUrl+"/saveBooking", bookingDetails, String.class);
	  
	  
  }
	
  
  
  private void validate(BookingDetailsDTO bookingDetails)throws BookingException {
	  
	  
	  if(bookingDetails==null){
		  throw  new BookingException("BOOK001","No booking details found");
	  }
	  
	  Passenger passenger = bookingDetails.getBooking().getPassenger();
		 
	  if( (!passenger.getPhoneNumber().startsWith("6") && !passenger.getPhoneNumber().startsWith("9"))){
		  
		  throw new BookingException("BOOK002","The phone number" +passenger.getPhoneNumber() +" is not correct");
	  }
	  
	  if(!validateDNI(passenger.getDni())){
		  throw new BookingException("BOOK003","The DNI " +passenger.getDni() +" is not correct");
	  }
	  
	  if(bookingDetails.getBooking().getCarrier()==null ||
		 bookingDetails.getBooking().getIataDestination()==null ||
		 bookingDetails.getBooking().getIataOrigin()==null )
					  
		  throw new BookingException("BOOK004","There is not enough information");
	
	
	  
	  return ;
	 
  }
  
  private boolean validateDNI(String dni){

      
      char[] DNIletters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};  

      String num= "";
      int ind = 0;  

      boolean result =false;

      //If length <8 we add a 0 at the begining
      if(dni.length() == 8) {
    	  dni = "0" + dni;
      }
      
      //Check there is a letter at the end
      if (!Character.isLetter(dni.charAt(8))) {
           return false;  
      }

      //Check it has 9 positions
      if (dni.length() != 9){   
           return false;
      }  

      // Check it starts with 
      for (int i=0; i<8; i++) {
 
           if(!Character.isDigit(dni.charAt(i))){
                 return false;    
           }
         
           num += dni.charAt(i);     
      }


      ind = Integer.parseInt(num);

      // Check the letter
      ind %= 23;

      if ((Character.toUpperCase(dni.charAt(8))) != DNIletters[ind]){
           return false;
     }  
     
     return true;
 } 

  
	
}
