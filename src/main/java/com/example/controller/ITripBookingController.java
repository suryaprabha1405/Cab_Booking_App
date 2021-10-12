package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.TripBooking;
import com.example.service.ICustomerService;
import com.example.service.ITripBookingService;


@RestController
@RequestMapping("/tripbooking")
public class ITripBookingController {

	@Autowired
	ITripBookingService itbs;
	@Autowired
	ICustomerService cusService;
	/**
	 * insertTripBooking
	 * 
	 * @param tripBooking
	 * @return TripBooking
	 */
	@PostMapping
	public TripBooking insertTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.insertTripBooking(tripBooking);
	}

	/**
	 * updateTripBooking
	 * 
	 * @param tripBooking
	 * @return TripBooking
	 */

	@PutMapping
	public TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.updateTripBooking(tripBooking);
	}

	/**
	 * deleteTripBooking
	 * 
	 * @param tripBooking
	 * @return List<TripBooking>
	 */

	@DeleteMapping
	public TripBooking deleteTripBooking(int tripBookingId) {
		return itbs.deleteTripBooking(tripBookingId);
	}

	/**
	 * viewAllTripsCustomer
	 * 
	 * @param customerId
	 * @return List<TripBooking>
	 */

	@GetMapping("/{customerId}")
	public List<TripBooking> viewAllTripsCustomer(@PathVariable int customerId) {
		return itbs.viewAllTripsCustomer(customerId);
	}

	/**
	 * calculateBill
	 * 
	 * @param customerId
	 * @return float
	 */
	@GetMapping("/calculate/{customerId}")
	public float calculateBill(@PathVariable int customerId) {
		return itbs.calculateBill(customerId);
	}

}
