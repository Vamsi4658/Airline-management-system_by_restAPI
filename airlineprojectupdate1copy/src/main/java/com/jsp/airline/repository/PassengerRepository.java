package com.jsp.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airline.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{


	@Query("SELECT p1 FROM Passenger p1 WHERE p1.bookingInfo.bookingId = :b_Id")
	List<Passenger> findBybookingid(@Param("b_Id") int bookingId);
}