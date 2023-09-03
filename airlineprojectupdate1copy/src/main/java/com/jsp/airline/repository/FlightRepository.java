package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.airline.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
}
