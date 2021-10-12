package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Customer;
import com.example.repository.ICustomerRepository;

@Service("cusService")
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository cDao;

	/**
	 * @param customer
	 * @return Customer
	 */

	@Override
	public Customer insertCustomer(Customer customer) {
		cDao.saveAndFlush(customer);
		return customer;
	}

	/**
	 * @param customer
	 * @return Customer
	 */

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cus = cDao.findById(customer.getCustomerId()).get();
		if (cus != null) {
			cus.setEmail(customer.getEmail());
			cus.setMobileNumber(customer.getMobileNumber());
			cus.setUsername(customer.getUsername());
			cus.setPassword(customer.getPassword());
			cDao.save(cus);
		}
		return cus;
	}

	/**
	 * @param customer
	 * @return Customer
	 */
	@Override
	public Customer deleteCustomer(int customerId) {
		cDao.deleteById(customerId);
		return null;
	}

	/**
	 * 
	 * @return List<Customer>
	 */

	@Override
	public List<Customer> viewCustomers() {

		return cDao.findAll();
	}

	/**
	 * @param customerId
	 * @return Customer
	 */

	@Override
	public Customer viewCustomer(int customerId) {
		return cDao.findById(customerId).get();
	}

	@Override
	public Customer validateCustomer(String username, String password) {

		return null;
	}

}
