package com.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Cab {
	@Id
	private int cabId;
	private String carType;
	private float perKmRate;
	
	@JsonIgnore
	@OneToOne(mappedBy="cab", cascade = CascadeType.ALL)
	private Driver driver;
	
	public Cab() {

	}

	public Cab(int cabId, String carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	public Driver getDriver() {
		return driver;
	} 
}