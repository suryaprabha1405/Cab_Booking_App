package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.InvalidUserOrPasswordException;
import com.example.service.ICustomerService;
import com.example.util.ILoginService;

@RestController
@RequestMapping("/customer")
public class ICustomerController {
	@Autowired
	ICustomerService cusService;

	@Autowired
	ILoginService ls;

	/**
	 * validateCustomer
	 */

	@PostMapping("/login")
	public String validateCustomer(@RequestBody Customer customer) throws InvalidUserOrPasswordException {
		String response;
		try {
			response = ls.validateCredintials(customer);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return response;
	}

	/**
	 * insertCustomer
	 */

	@PostMapping
	public Customer insertCustomer(@RequestBody Customer customer) {
		return cusService.insertCustomer(customer);
	}

	@SuppressWarnings("unused")
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer cViewer = null;
		Customer c = null;
		try {
			cViewer = viewCustomer(customer.getCustomerId());
			c = cusService.updateCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Update Operation!");
		}
		return c;
	}

	/**
	 * deleteCustomer
	 */

	@SuppressWarnings("unused")
	@DeleteMapping
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {
		Customer cViewer = null;
		Customer c = null;
		try {
			cViewer = viewCustomer(customerId);
			c = cusService.deleteCustomer(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Delete Operation!");
		}
		return c;
	}

	/**
	 * viewCustomers
	 */

	@GetMapping(value = "all")
	public List<Customer> viewCustomers() {
		return cusService.viewCustomers();
	}

	/**
	 * viewCustomer
	 */

	@GetMapping(value = "/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
		Customer c = null;
		try {
			c = cusService.viewCustomer(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer with Id: " + customerId + " Not Found!");
		}
		return c;
	}

}
