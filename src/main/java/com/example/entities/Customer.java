package com.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer extends AbstractUser {
	@Id
	private int customerId;

	@JsonIgnore
	@OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
	private TripBooking tripBooking;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@JsonIgnore
	public TripBooking getTripBooking() {
		return tripBooking;
	} 
	
	
	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

}