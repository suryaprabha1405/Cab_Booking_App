package com.example.service;

import java.util.List;
import com.example.entities.Customer;

public interface ICustomerService {
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	public Customer validateCustomer(String username, String password);
	Customer deleteCustomer(int customerId);
}