package com.example.service;


import java.util.List;

import com.example.entities.TripBooking;


public interface ITripBookingService {

	public TripBooking insertTripBooking(TripBooking tripBooking);

	public TripBooking updateTripBooking(TripBooking tripBooking);


	public List<TripBooking> viewAllTripsCustomer(int customerId);

	public float calculateBill(int customerId);

	public TripBooking deleteTripBooking(int tripBookingId);
	
	
}