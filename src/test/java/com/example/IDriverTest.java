package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.example.entities.Cab;
import com.example.entities.Driver;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class IDriverTest extends AbstractTest {

	@Override

	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	@Test
	public void bestDriversTestCase() throws Exception {
		String uri = "/driver/bestdrivers";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Driver driver[] = super.mapFromJson(content, Driver[].class);
		boolean flag = true;
		for (Driver d : driver) {
			if (d.getRating() < 4.5) {
				flag = false;
			}
			assertEquals(true, flag);
		}
	}

	/**
	 * insertDriverTestCase
	 * 
	 * @throws Exception
	 */
	@Test
	public void insertDriverTestCase() throws Exception {

		String uri = "/driver";
		Cab c = new Cab(3, "Macro", 8);
		Driver d = new Driver(202, "license", c, 4.8f);
		d.setUsername("driver1");
		String inputJson = super.mapToJson(d);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Driver driver[] = super.mapFromJson(content, Driver[].class);
		assertEquals("driver1", driver[driver.length - 1].getUsername());

	}

	@Test
	public void updateDriver() throws Exception {
		String uri = "/driver/202";
		String uriPost = "/driver";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Driver driver = super.mapFromJson(content, Driver.class);
		driver.setEmail("updatedEmail.com");
		String inputJson = super.mapToJson(driver);
		MvcResult mvcResultt = mvc.perform(
				MockMvcRequestBuilders.put(uriPost).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int postStatus = mvcResultt.getResponse().getStatus();
		assertEquals(200, postStatus);
		String responseContent = mvcResultt.getResponse().getContentAsString();
		Driver d = super.mapFromJson(responseContent, Driver.class);
		assertEquals("updatedEmail.com", d.getEmail());

	}

	/**
	 * View Driver by Id
	 * 
	 * @throws Exception
	 */
	@Test
	public void viewDriver() throws Exception {
		String uri = "/driver/202";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Driver driver = super.mapFromJson(content, Driver.class);
		assertEquals("driver1", driver.getUsername());
	}
	
	/**
	 * deleteDriver
	 * 
	 * @throws Exception
	 */
	@Test
	public void deleteDriver() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.delete("/driver/202").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
}
