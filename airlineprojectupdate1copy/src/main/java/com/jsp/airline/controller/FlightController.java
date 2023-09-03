package com.jsp.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.FlightDto;
import com.jsp.airline.service.AdminService;
@RestController
@RequestMapping("/v1/flight")
public class FlightController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/search/{fNum}")
	public ResponseEntity<List<FlightDto>> searchByFlightNumber(@PathVariable("fNum") String flightNumber){
		return ResponseEntity.status(HttpStatus.FOUND).body(adminService.searchByFlightNumber(flightNumber));
	}
	
//	public entity\ 
}
