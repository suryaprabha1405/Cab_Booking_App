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

import com.example.entities.Cab;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class ICabTest extends AbstractTest{

	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	/**
	 * deleteCab
	 * 
	 * @throws Exception
	 */
	@Test
	public void deleteCab() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.delete("/cab/4").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	/**
	 * countCabsByType
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void getCabById() throws Exception {
		String uri = "/cab/9";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Cab cab = super.mapFromJson(content, Cab.class);
		assertEquals("PrimeSUV", cab.getCarType());

	}
	
}
