package com.example.service;

import java.util.List;

import com.example.entities.Cab;

public interface ICabService {
	public Cab insertCab(Cab cab);

	public Cab updateCab(Cab cab);

	public Cab deleteCab(Cab cab);

	public List<Cab> viewCabsOfType(String carType);

	public int countCabsOfType(String carType);

	public Cab getCabById(int cabID);

	public List<Cab> deleteCabById(int cabID);
}