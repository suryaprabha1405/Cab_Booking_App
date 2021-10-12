package com.example.service;

import java.util.List;
import com.example.entities.Driver;
import com.example.exception.DriverNotFoundException;

public interface IDriverService {

	public Driver viewDriver(int driverId) throws DriverNotFoundException;

	public List<Driver> viewBestDrivers() throws DriverNotFoundException;

	public List<Driver> insertDriver(Driver driver);

	public Driver updateDriver(Driver driver) throws DriverNotFoundException;

	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException;

	public Driver getDriverById(int driverId);
	
}
