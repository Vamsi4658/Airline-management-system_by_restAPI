package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.AirlineInformation;

public interface AirlineInfoRepository extends JpaRepository<AirlineInformation, Integer>{

	
}
