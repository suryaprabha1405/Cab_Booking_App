package com.example.dao;

import java.util.List;

import com.example.entities.Cab;
import com.example.exception.CabNotFoundException;

public interface ICabDao {

	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;

	public int countCabsOfType(String carType) throws CabNotFoundException;
}