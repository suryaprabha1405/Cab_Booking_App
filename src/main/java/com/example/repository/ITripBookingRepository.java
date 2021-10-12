package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.ITripBookingDao;
import com.example.entities.TripBooking;

@Repository("tbDao")
public interface ITripBookingRepository extends ITripBookingDao, JpaRepository<TripBooking, Integer> {

}