package com.jsp.airline.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BookingInfoDto {

	private LocalDate bookingDate;
	private String destination;
	private double fareCost;
	private LocalDate flyingDate;
	private String flightNumber;
	private String status;
	private LocalTime flightTime;
	private String currentCity;
	private List<PassengerDto> passengers;
	
}
