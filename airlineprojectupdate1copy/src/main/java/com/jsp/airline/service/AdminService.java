package com.jsp.airline.service;

import java.time.LocalDate;
import java.util.List;

import com.jsp.airline.dto.AirlineInfoDto;
import com.jsp.airline.dto.BookingInfoDto;
import com.jsp.airline.dto.CheckInDto;
import com.jsp.airline.dto.FareDto;
import com.jsp.airline.dto.FlightDto;
import com.jsp.airline.dto.FlightInfoDto;
import com.jsp.airline.dto.InventoryDto;
import com.jsp.airline.dto.PassengerDto;
import com.jsp.airline.entity.Flight;

public interface AdminService {
	/*
	 *   creating the admin services  
	 */
	// post methods
	
	int addAirlineInfo(AirlineInfoDto dto);
	int addflightInfo(FlightInfoDto dto, int id);
	int addFare(FareDto dto);
	int addInventory(InventoryDto dto);
	int addFlight(FlightDto dto, int flightInfoId, int fareId, int inventoryId);
	int addBookingDetails(BookingInfoDto dto);
	int addCheckInData(CheckInDto dto);
	int addPassenger(PassengerDto dto, int bookingId, int checkinId);
	
	/*
	 *   get methods
	 */
	AirlineInfoDto getAirlineInfoById(int id);
	List<PassengerDto> getPassengerByBookingId(int id);
	BookingInfoDto getBookingInfoById(int id);
	List<BookingInfoDto> getAllBookingInfo();
	
	
	// flight service
	
//	List<FlightDto> getFlightDetails(String startLocation, String destination, LocalDate flightDate,
//			String flightNumber);
	
//	FlightDto searchFlightDetails(/* String startLocation, String destination, LocalDate flightDate, String flightNumber ,*/int flightId, int fareId, int flightInfoId, int inventoryId);
	
//	FlightDto search( int fare, int flightInfo, int inventory);
	
	List<FlightDto> getAllFlight();
	
	List<FlightDto> searchByFlightNumber(String flightNumber);
	
	List<FlightDto> searchByCurrentCityAndDestianationAndDate(FlightDto dto);
}
