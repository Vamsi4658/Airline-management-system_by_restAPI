package com.jsp.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.AirlineInfoDto;
import com.jsp.airline.dto.BookingInfoDto;
import com.jsp.airline.dto.CheckInDto;
import com.jsp.airline.dto.FareDto;
import com.jsp.airline.dto.FlightDto;
import com.jsp.airline.dto.FlightInfoDto;
import com.jsp.airline.dto.InventoryDto;
import com.jsp.airline.dto.PassengerDto;
import com.jsp.airline.service.AdminService;

@RestController
@RequestMapping("/v1/Admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	/*
	 * _________________________________
	 *     Post mapping
	 * ---------------------------------
	 */
	@PostMapping("/add/airline")
	/*
	 *   create API for Add Airline Information
	 */
	public ResponseEntity<String> addAirline(@RequestBody AirlineInfoDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body("Airline Id is: "+adminService.addAirlineInfo(dto));
	}

	@PostMapping("/add/flightinfo/{id}")
	/*
	 *  create API for Add Flight Information 
	 */
	public ResponseEntity<String> addFlightInfo(@RequestBody FlightInfoDto dto,@PathVariable("id") int id){
		int flightInfoId = adminService.addflightInfo(dto, id);
		if ( flightInfoId !=0) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Flight_info_id is: "+flightInfoId);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid data/invalid Airline_id");
		}
	}
	/*
	 *   create API for add Fare
	 */
	@PostMapping("/add/fare")
	public ResponseEntity<String> addFare(@RequestBody FareDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body("fare Id is: "+adminService.addFare(dto));
	}
	/*
	 *  create API for add Inventory Data
	 */
	@PostMapping("/add/inventory")
	public ResponseEntity<String> addInventory(@RequestBody InventoryDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body("inventory id id: "+adminService.addInventory(dto));
	}
	/*
	 *  create API for add Flight data
	 */
	@PostMapping("/add/flight/{fId}/{fareId}/{iId}")
	public ResponseEntity<String> addFlightData(@RequestBody FlightDto dto,@PathVariable("fId") int flightInfoId,@PathVariable("fareId") int fareId,@PathVariable("iId") int inventoryId) {
		int flightId = adminService.addFlight(dto, flightInfoId, fareId, inventoryId);
		if ( flightId!=0) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Flight Id is: "+flightId);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid data/id");
		}
	}
	/*
	 *  create API for Check-In data
	 */
	@PostMapping("add/checkin")
	public ResponseEntity<String> addCheckin(@RequestBody CheckInDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body("checkin Id is: "+adminService.addCheckInData(dto));
	}
	/*
	 *  create API for booking
	 */
	@PostMapping("add/register/booking")
	public ResponseEntity<String> addBookinginfo(@RequestBody BookingInfoDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body("booking id is: "+adminService.addBookingDetails(dto));
	}
	/*
	 *  create for add passenger
	 */
	@PostMapping("add/passenger/{bId}/{cId}")
	public ResponseEntity<String> addPassenger(@RequestBody PassengerDto dto, @PathVariable("bId") int BookingId, @PathVariable("cId") int checkin) {
		int passengerId = adminService.addPassenger(dto, BookingId, checkin);
		if (passengerId != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body("passenger id is: "+passengerId);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("passenger id is: ");
		}
	}
	
	/*
	 * 
	 * 
	 *   fetching (Get) GetMapping
	 * 
	 * 
	 */
	@GetMapping("/get/bookingdetails/{id}")
	public ResponseEntity<BookingInfoDto> getBookingInfoById(@PathVariable("id") int id) {
		
		if (adminService.getBookingInfoById(id) != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.getBookingInfoById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/get/bookingdetails/all")
	public ResponseEntity<List<BookingInfoDto>> getAllBookingInfo() {
		
		if (adminService.getAllBookingInfo() != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.getAllBookingInfo());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	@GetMapping("/get/bookinginfo/{id}")
	public List<PassengerDto> getPassengerDetails(@PathVariable("id") int id) {
		if (adminService.getPassengerByBookingId(id) != null) {
			return adminService.getPassengerByBookingId(id);
		} else {
			return null;
		}
	}
	@GetMapping("/get/airlineinfo/{id}")
	public ResponseEntity<AirlineInfoDto> getAirlineInfoById(@PathVariable("id") int id) {
		if (adminService.getAirlineInfoById(id) != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.getAirlineInfoById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
}
