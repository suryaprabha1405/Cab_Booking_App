package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.entities.Customer;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class ICustomerTest extends AbstractTest{
	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	
	/**
	 * insertCustomer
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void insertCustomer() throws Exception {
		
		String uri = "/customer";
		Customer customer = new Customer(45465);

		customer.setEmail("customer@g.com");
		customer.setMobileNumber("9182829300");
		customer.setPassword("kishoreTheGreat");
		customer.setUsername("krish");
		String inputJson = mapToJson(customer);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	
}
