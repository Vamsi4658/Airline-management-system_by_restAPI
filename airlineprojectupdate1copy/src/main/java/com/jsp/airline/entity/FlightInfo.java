package com.jsp.airline.entity;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "flight_info_table")
public class FlightInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightInfoId;
	private String flightNumber;
	private LocalTime flightTime;
	private String flightType;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "flightInfo")
	private Flight flight;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "airline_Id")
	private AirlineInformation airlineinfo;
}
