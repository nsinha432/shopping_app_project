package com.cart.dao.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.cart.dao.service.CartDAOService;

class testCheckProductId {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCheckProductID_WhenCorrectIDEntered() {
		//fail("Not yet implemented");
		CartDAOService cartDAOServiceImpl = new CartDAOServiceImpl();
		
		try {
			cartDAOServiceImpl.checkProductID(12);
			assertTrue(true);
			
		} catch (BusinessException e) {
			fail("Exception thrown");
		}
	}
	
	@Test
	void testCheckProductID_WhenIncorrectIDEntered() {
	CartDAOService cartDAOServiceImpl = new CartDAOServiceImpl();
		
		try {
			cartDAOServiceImpl.checkProductID(12342);
			fail("No Exception thrown");
		} catch (BusinessException e) {
			assertTrue(true);
		}
	}

}
