package com.jsp.airline.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.FlightDto;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.repository.FlightRepository;
@Service
public class FlightServiceImp implements FlightService{

	@Autowired
	private FlightRepository flightRepository;

	
	
	
}
