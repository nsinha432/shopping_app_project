package com.app.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.dao.CustomerSearchDAO;
import com.app.exception.BusinessException;
import com.app.model.Customer;

class testCustomerSearchDAOImpl {

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

	/*@Test
	void testGetAllCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomersByFname() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomersByLname() {
		fail("Not yet implemented");
	}
*/
	
	@Test
	void testGetCustomerByEmail_sameEmail() {
		
		//fail("Not yet implemented");
		
		Customer customer = new Customer("nsinha432@gmail.com", "nikhil", "sinha", null);
		
		
		
		CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();
		
		try {
			Customer customer2 =  customerSearchDAO.getCustomerByEmail("nsinha432@gmail.com");
			assertEquals(customer, customer2, "Incorrect selection");
			
		} catch (BusinessException e) {
			fail("Exception thrown");
		}
		
	}

	@Test
	void testGetCustomerByEmail_differentEmail() {
		
		//fail("Not yet implemented");
		
		Customer customer = new Customer("nsinha432@gmail.com", "nikhil", "sinha", null);
		
		
		
		CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();
		
		try {
			Customer customer2 =  customerSearchDAO.getCustomerByEmail("nikhil@gmail.com");
			assertNotEquals(customer, customer2, "Correct selection");
			
		} catch (BusinessException e) {
			fail("Exception thrown");
		}
		
	}
	
}
