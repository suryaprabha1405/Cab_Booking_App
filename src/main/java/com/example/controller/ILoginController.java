package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Admin;
import com.example.entities.Customer;
import com.example.entities.Driver;
import com.example.exception.InvalidUserOrPasswordException;
import com.example.util.ILoginServiceImpl;

@RestController
@RequestMapping("/login/")
public class ILoginController {
	@Autowired
	ILoginServiceImpl lServiceImpl;

	@GetMapping("/customer/{username}/{password}")
	public String customerLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {
		try {
			Customer customer = new Customer();
			customer.setUsername(username);
			customer.setPassword(password);

			return lServiceImpl.validateCredintials(customer);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}

	@GetMapping("/admin/{username}/{password}")
	public String adminLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

		try {
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			return lServiceImpl.validateCredintials(admin);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}

	@GetMapping("/driver/{username}/{password}")
	public String driverLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

		try {
			Driver driver = new Driver();
			driver.setUsername(username);
			driver.setPassword(password);
			return lServiceImpl.validateCredintials(driver);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}
}
