package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.entities.Admin;
import com.example.entities.TripBooking;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class IAdminTest extends AbstractTest{
	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	/**
	 * viewAllAdmin
	 * 
	 * @throws Exception
	 */
	@Test
	public void viewAllAdmin() throws Exception {
		String uri = "/admin";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Admin admin[] = super.mapFromJson(content, Admin[].class);
		assertEquals(3, admin[0].getAdminId());
	}

	/**
	 * createAdmin
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void insertAdmin() throws Exception {
		
		
		String uri = "/admin";
		Admin admin = new Admin(1);
		admin.setEmail("creator@cab.in");
		admin.setMobileNumber("756324189");
		admin.setPassword("password");
		admin.setUsername("admin1");

		String inputJson = super.mapToJson(admin);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		

	}

	/**
	 * updateAdmin
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateAdmin() throws Exception {
		String uri = "/admin/1";
		String uriPost = "/admin";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Admin admin = super.mapFromJson(content, Admin.class);
		admin.setEmail("updatedEmail.com");
		String inputJson = super.mapToJson(admin);
		MvcResult mvcResultt = mvc.perform(
				MockMvcRequestBuilders.post(uriPost).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int postStatus = mvcResultt.getResponse().getStatus();
		assertEquals(200, postStatus);
		String responseContent = mvcResultt.getResponse().getContentAsString();
		Admin a = super.mapFromJson(responseContent, Admin.class);
		assertEquals("updatedEmail.com", a.getEmail());

	}

	/**
	 * deleteAdmin
	 * 
	 * @throws Exception
	 */
	@Test
	public void deleteAdmin() throws Exception {

		this.mvc.perform(MockMvcRequestBuilders.delete("/admin/0").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	/**
	 * getAdminById
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAdminById() throws Exception {
		String uri = "/admin/3";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Admin admin = super.mapFromJson(content, Admin.class);
		assertEquals("admin3", admin.getUsername());
	}

	/**
	 * showAllTrips
	 * 
	 * @throws Exception
	 */
	@Test
	public void showAllTrips() throws Exception {
		String uri = "/admin/alltrips/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		TripBooking tripList[] = super.mapFromJson(content, TripBooking[].class);
		assertEquals(2, tripList[0].getCustomer().getCustomerId());

	}

}
