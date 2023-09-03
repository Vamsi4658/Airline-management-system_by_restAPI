 package com.jsp.airline.dto;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class FlightDto {
	
	private String destination;
	private LocalDate flightDate;
	private String flightNumber;
	private LocalTime flightTime;
	private String currentLocation;
	private String duration;
	
	// foreign key
	private FareDto fareId;
	private FlightInfoDto flightInfoId;
	private InventoryDto inventoryId;

}
