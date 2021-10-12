package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entities.TripBooking;

import com.example.repository.ITripBookingRepository;

@Service("itbs")
public class ITripBookingServiceImpl implements ITripBookingService {
	@Autowired
	ITripBookingRepository tbDao;

	/**
	 * @param tripBooking
	 * @return TripBooking
	 */
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		tbDao.saveAndFlush(tripBooking);
		return tripBooking;
	}

	/**
	 * @param tripBooking
	 * @return TripBooking
	 */

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		return tbDao.saveAndFlush(tripBooking);
	}

	/**
	 * @param tripBooking
	 * @return List<TripBooking>
	 */

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		tbDao.deleteById(tripBookingId);
		return null;
	}

	/**
	 * @param customerId
	 * @return List<TripBooking>
	 */

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		return tbDao.viewAllTripsCustomer(customerId);
	}

	/**
	 * @param customerId
	 * @return float
	 */

	@Override
	public float calculateBill(int customerId) {
		return tbDao.calculateBill(customerId);
	}

	

}
