package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Admin;
import com.example.entities.Customer;
import com.example.entities.TripBooking;
import com.example.exception.AdminNotFoundException;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.InvalidUserOrPasswordException;
import com.example.service.IAdminService;
import com.example.service.ICustomerService;
import com.example.util.ILoginService;


@RestController
@RequestMapping("/admin")

public class IAdminController {

	@Autowired
	IAdminService ias;

	@Autowired
	ILoginService ls;

	@Autowired
	ICustomerService cusService;

	@PostMapping("/login")
	public String validateAdmin(@RequestBody Admin admin) throws InvalidUserOrPasswordException {
		String response;
		try {
			response = ls.validateCredintials(admin);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return response;
	}

	@GetMapping
	public List<Admin> viewALlAdmin() {
		return ias.viewALlAdmin();
	}

	@PostMapping
	public Admin insertAdmin(@RequestBody Admin admin) {
		return ias.insertAdmin(admin);
	}

	@DeleteMapping("/{adminId}")
	public List<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException {
		List<Admin> s = null;
		try {
			s = ias.deleteAdmin(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with given ID: " + adminId + " Not Found to Delete");
		}
		return s;

	}

	@PutMapping
	public Admin updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(admin.getAdminId());
			ias.updateAdmin(admin);
		} catch (Exception e) {
			throw new AdminNotFoundException("Admin Not Found to Update");
		}
		return a;
	}

	@GetMapping("/{adminId}")
	public Admin GetAdminById(@PathVariable int adminId) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with ID: " + adminId + " not found!");
		}
		return a;
	}

	@SuppressWarnings("unused")
	@GetMapping("/alltrips/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable int customerId) throws CustomerNotFoundException {

		Customer c = null;
		List<TripBooking> t = null;
		try {
			c = cusService.viewCustomer(customerId);
			t = ias.getAllTrips(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Can not find trips of Customer ID: " + customerId);
		}
		return t;
	}

	@GetMapping("/cabwise")
	public List<TripBooking> getTripsCabwise() {
		return ias.getTripsCabwise();
	}

	@GetMapping("/customerwise")
	public List<TripBooking> getTripsCustomerwise() {
		return ias.getTripsCustomerwise();
	}

	@GetMapping("/datewise")
	public List<TripBooking> getTripsDatewise() {
		return ias.getTripsDatewise();
	}


	@GetMapping("fordays/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
			throws CustomerNotFoundException {
		return ias.getAllTripsForDays(customerId, fromDate, toDate);
	}

}