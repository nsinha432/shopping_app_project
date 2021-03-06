package com.customer.search.service.imp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.customer.search.service.CustomerSearchService;
import com.customer.search.service.impl.CustomerSearchServiceImpl;

class testCustomerSearchService {

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
	void testCheckFname_CorrectFname() {
		// fail("Not yet implemented");

		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		try {
			customerSearchService.checkFname("nikhil");
			assertTrue(true);
		} catch (BusinessException e) {
			fail("Exception thrown");
		}

	}
	
	
	@Test
	void testCheckFname_IncorrectFname() {
		// fail("Not yet implemented");

		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		try {
			customerSearchService.checkFname("jabfubuf76sasfjbajsw");
			fail("No Exception thrown");
		} catch (BusinessException e) {
			assertTrue(true);
			
		}

	}
	

	@Test
	void testCheckLname_CorrectLname() {
		
		//fail("Not yet implemented");
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		try {
			customerSearchService.checkLname("sinhsa");
			assertTrue(true);
		} catch (BusinessException e) {
			fail("Exception thrown");
		}
	}
	
	@Test
	void testCheckLname_IncorrectLname() {
		
		//fail("Not yet implemented");
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		try {
			customerSearchService.checkLname("sinh3r231sa");
			fail("No Exception thrown");
		} catch (BusinessException e) {
			assertTrue(true);
			
		}
	}
	

	@Test
	void testCheckEmail_WhenCorrectEmail() {
		//fail("Not yet implemented");
		
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		try {
			customerSearchService.checkEmail("nikhil@gmail.com");
			assertTrue(true);
		} catch (BusinessException e) {
			fail("Exception thrown");
		}
		
		
	}

	@Test
	void testCheckEmail_WhenIncorrectEmail() {
		//fail("Not yet implemented");
		
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		try {
			customerSearchService.checkEmail("nikhilgmail.com");
			fail("No Exception thrown");
			
		} catch (BusinessException e) {
			assertTrue(true);
		}
		
		
	}
	
}
