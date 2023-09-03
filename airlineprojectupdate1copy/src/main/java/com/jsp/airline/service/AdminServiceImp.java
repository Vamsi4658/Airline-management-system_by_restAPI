package com.jsp.airline.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.AirlineInfoDto;
import com.jsp.airline.dto.BookingInfoDto;
import com.jsp.airline.dto.CheckInDto;
import com.jsp.airline.dto.FareDto;
import com.jsp.airline.dto.FlightDto;
import com.jsp.airline.dto.FlightInfoDto;
import com.jsp.airline.dto.InventoryDto;
import com.jsp.airline.dto.PassengerDto;
import com.jsp.airline.entity.AirlineInformation;
import com.jsp.airline.entity.BookingInformation;
import com.jsp.airline.entity.CheckIn;
import com.jsp.airline.entity.Fare;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.entity.FlightInfo;
import com.jsp.airline.entity.Inventory;
import com.jsp.airline.entity.Passenger;
import com.jsp.airline.repository.AirlineInfoRepository;
import com.jsp.airline.repository.BookingInfoRepository;
import com.jsp.airline.repository.CheckInRepository;
import com.jsp.airline.repository.FareRepository;
import com.jsp.airline.repository.FlightInfoRepository;
import com.jsp.airline.repository.FlightRepository;
import com.jsp.airline.repository.InventoryRepository;
import com.jsp.airline.repository.PassengerRepository;

@Service
public class AdminServiceImp implements AdminService{

	/*
	 *   repositories
	 */
	@Autowired
	private AirlineInfoRepository airlineInfoRepository;
	@Autowired
	private FlightInfoRepository flightInfoRepository;
	@Autowired
	private FareRepository fareRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private BookingInfoRepository bookingInfoRepository;
	@Autowired
	private CheckInRepository checkInRepository;
	@Autowired
	private PassengerRepository passengerRepository;
//	@Autowired
	//private UserRepository userRepository;
	/*
	 * ______________________________________________________________________________________________________________
	 *      
	 *                                   ********* service methods *********
	 *  
	 *  _____________________________________________________________________________________________________________
	 *
	 *  
	 *  adding Airline Information
	 */
	@Override
	public int addAirlineInfo(AirlineInfoDto dto) {
		AirlineInformation airlineInformation = airlineInfoRepository.save(AirlineInformation.builder()
				.airlineName(dto.getAirlineName())
				.build());
		return airlineInformation.getAirlineId();
	}
	/*
	 *  ---->>  add Flight Informantion
	 */
	@Override
	public int addflightInfo(FlightInfoDto dto, int id) {
		// get airline from Db
		Optional<AirlineInformation> optional = airlineInfoRepository.findById(id);
		if (optional.isPresent()) {
			// add data
			FlightInfo flightInfo = flightInfoRepository.save(FlightInfo.builder()
					.flightNumber(dto.getFlightNumber())
					.flightType(dto.getFlightType())
					.flightTime(dto.getFlightTime())
					.airlineinfo(optional.get())
					.build());
				return flightInfo.getFlightInfoId();
		} else {
			return 0;
		}	
	}
	/*
	 * 
	 * 
	 * 
	 *   Adding Fare Data
	 */
	@Override
	public int addFare(FareDto dto) {
		Fare fare = fareRepository.save(Fare.builder()
				.currancy(dto.getCurrancy())
				.amount(dto.getAmount())
				.build());
		
		return fare.getFareId();
	}
	/*
	 *  Add Inventory Data
	 */
	@Override
	public int addInventory(InventoryDto dto) {
		Inventory inventory = inventoryRepository.save(Inventory.builder()
				.count(dto.getCount())
				.build());
		return inventory.getInventoryId();
	}
	/*
	 *  add Flight Data
	 */
	@Override
	public int addFlight(FlightDto dto , int flightInfoId, int fareId, int inventoryId) {
		// get the foreignkey data
		Optional<FlightInfo> flightInfo = flightInfoRepository.findById(flightInfoId);
		Optional<Fare> fare = fareRepository.findById(fareId);
		Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
		
		// validating the data
		if (flightInfo.isPresent() && fare.isPresent() &&  inventory.isPresent()) {
			Flight flight = flightRepository.save(Flight.builder()
					.destination(dto.getDestination())
					.flightDate(dto.getFlightDate())
					.flightNumber(dto.getFlightNumber())
					.flightTime(dto.getFlightTime())
					.currentLocation(dto.getCurrentLocation())
					.fare(fare.get())
					.flightInfo(flightInfo.get())
					.inventory(inventory.get())
					.build());
			return flight.getFlightId();
		} else {
			return 0;
		}
	}
	/*
	 *  add Booking information data
	 */
	@Override
	public int addBookingDetails(BookingInfoDto dto) {
		BookingInformation bookingInfo = bookingInfoRepository.save(BookingInformation.builder()
				.bookingDate(dto.getBookingDate())
				.destination(dto.getDestination())
				.fareCost(dto.getFareCost())
				.flyingDate(dto.getFlyingDate())
				.flightNumber(dto.getFlightNumber())
				.status(dto.getStatus())
				.flightTime(dto.getFlightTime())
				.currentCity(dto.getCurrentCity())
				.build());
		return bookingInfo.getBookingId();
	}
	/*
	 *  add CheckIn data
	 */
	@Override
	public int addCheckInData(CheckInDto dto) {
		CheckIn checkIn = checkInRepository.save(CheckIn.builder()
				.seatNo(dto.getSeatNo())
				.gateNo(dto.getGateNo())
				.build());
		return checkIn.getCheckinId();
	}
	/*
	 * 
	 *  Add Passenger Data
	 *  
	 */
	@Override
	public int addPassenger(PassengerDto dto, int bookingId, int checkinId) {
		Optional<BookingInformation> bookingInfo = bookingInfoRepository.findById(bookingId);
		Optional<CheckIn> checkin = checkInRepository.findById(checkinId);
		if (bookingInfo.isPresent() && checkin.isPresent()) {
			Passenger passenger = passengerRepository.save(Passenger.builder()
					.emailId(dto.getEmailId())
					.firstName(dto.getFirstName())
					.lastName(dto.getLastName())
					.mobileNumber(dto.getMobileNumber())
					.gender(dto.getGender())
					.bookingInfo(bookingInfo.get())
					.checkin(checkin.get())
					.build());
			return passenger.getPassengerId();
		} else {
			return 0;
		}
	}
	
	
	/*
	 * 
	 *  Get methods
	 * 
	 */
	@Override
	public BookingInfoDto getBookingInfoById(int id) {
		Optional<BookingInformation> bookingInfo = bookingInfoRepository.findById(id);
		if (bookingInfo.isPresent()) {
			BookingInformation b1 = bookingInfo.get();
			// transfer data entity to DTO
			BookingInfoDto bookingInfoDto = BookingInfoDto.builder()
					.bookingDate(b1.getBookingDate())
					.destination(b1.getDestination())
					.fareCost(b1.getFareCost())
					.flyingDate(b1.getFlyingDate())
					.flightNumber(b1.getFlightNumber())
					.status(b1.getStatus())
					.flightTime(b1.getFlightTime())
					.currentCity(b1.getCurrentCity())
					.build();
			return bookingInfoDto;
		} else {
			return null;
		}
	}
	/*
	 *  get all Booking list
	 */
	@Override
	public List<BookingInfoDto> getAllBookingInfo() {
		List<BookingInformation> bookingInfos = bookingInfoRepository.findAll();
		if (bookingInfos.size() > 0) {
			// transfer list of entity to list of Dto
			List<BookingInfoDto> list = bookingInfos.stream()
					.map(t -> BookingInfoDto.builder()
							.bookingDate(t.getBookingDate())
							.destination(t.getDestination())
							.fareCost(t.getFareCost())
							.flyingDate(t.getFlyingDate())
							.flightNumber(t.getFlightNumber())
							.status(t.getStatus())
							.flightTime(t.getFlightTime())
							.currentCity(t.getCurrentCity())
							.build())
					.collect(Collectors.toList());
			return list;
		} else {
			return null;
		}
	}
	@Override
	public List<PassengerDto> getPassengerByBookingId(int id) {
		List<Passenger> passengerList = passengerRepository.findBybookingid(id);
		if (passengerList.size() > 0) {
			List<PassengerDto> list =passengerList.stream()
					.map(t -> PassengerDto.builder()
							.emailId(t.getEmailId())
							.firstName(t.getFirstName())
							.build())
					.collect(Collectors.toList());
			return list;
		} else {
			return null;
		}
	}
	/*
	 *  
	 *  get airline by id
	 * 
	 */
	@Override
	public AirlineInfoDto getAirlineInfoById(int id) {
		Optional<AirlineInformation> airline = airlineInfoRepository.findById(id);
		if (airline.isPresent()) {
			AirlineInformation airlineInformation = airline.get();
			/* transfer entity to DTO */
			AirlineInfoDto dto = AirlineInfoDto.builder()
					.airlineName(airlineInformation.getAirlineName()).build();
			return dto;
		} else {
			return null;
		}
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 *      search flight by starting location, destination, flightDate, flightNumder
	 * 
	 * 
	 */
	@Override
	public List<FlightDto> getAllFlight() {
		
		return flightRepository.findAll().stream()
				.map(flightDB -> FlightDto.builder()
						.currentLocation(flightDB.getCurrentLocation())
						.destination(flightDB.getDestination())
						.flightDate(flightDB.getFlightDate())
						.duration(flightDB.getDuration())
						.flightDate(flightDB.getFlightDate())
						.flightTime(flightDB.getFlightTime())
						.flightNumber(flightDB.getFlightNumber())
//						.inventoryId(InventoryDto.builder()
//								.count(flightDB.getInventoryId().getCount())
//								.build())
//						.flightInfoId(FlightInfo.builder()
//								.airlineinfo(flightDB.getFlightInfoId().getAirlineinfo().getAirlineName())
//								.build())
//						.fareId(FareDto.builder()
//								.amount(flightDB.getFareId().getAmount())
//								.currancy(flightDB.getFareId().getCurrancy())
//								.build())
						.build()).collect(Collectors.toList());
	}
	@Override
	public List<FlightDto> searchByFlightNumber(String flightNumber) {
		
		return getAllFlight().stream()
//				.filter(flights -> Fligth)
				.collect(Collectors.toList());
				
	}
	@Override
	public List<FlightDto> searchByCurrentCityAndDestianationAndDate(FlightDto dto) {
		
		return getAllFlight().stream().filter(flights -> flights.getCurrentLocation().equals(dto.getCurrentLocation())
				&& flights.getDestination().equals(dto.getDestination())
				&& flights.getFlightDate().equals(dto.getFlightDate())).collect(Collectors.toList());
	}
}