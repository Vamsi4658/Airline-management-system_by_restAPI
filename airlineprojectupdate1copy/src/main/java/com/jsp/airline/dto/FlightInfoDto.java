package com.jsp.airline.dto;

import java.time.LocalTime;

import com.jsp.airline.entity.AirlineInformation;
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
public class FlightInfoDto {

	private String flightNumber;
	private LocalTime flightTime;
	private String flightType;
	private AirlineInformation airlineinfo;
}
