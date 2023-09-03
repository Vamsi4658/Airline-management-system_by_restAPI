package com.jsp.airline.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "booking_info_table")
public class BookingInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private LocalDate bookingDate;
	private String destination;
	private double fareCost;
	private LocalDate flyingDate;
	private String flightNumber;
	private String status;
	private LocalTime flightTime;
	
	private String currentCity;
	// foreign key
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "bookingInfo")
	private List<Passenger> passenger;
}
