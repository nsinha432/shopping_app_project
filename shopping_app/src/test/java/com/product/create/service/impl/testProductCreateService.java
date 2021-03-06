package com.product.create.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.product.create.service.ProductCreateService;
import com.product.search.service.ProductSearchService;

class testProductCreateService {

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
	void testCheckName_CorrectName() {
		// fail("Not yet implemented");

		ProductCreateService productCreateService = new ProductCreateServiceImpl();

		try {
			productCreateService.checkName("abcde");
			assertTrue(true);

		} catch (BusinessException e) {
			fail("Exception thrown");
		}

	}

	@Test
	void testCheckName_IncorrectName() {
		// fail("Not yet implemented");

		ProductCreateService productCreateService = new ProductCreateServiceImpl();

		try {
			productCreateService.checkName("abcde3r24fds3");
			fail("No Exception thrown");

		} catch (BusinessException e) {
			assertTrue(true);

		}

	}

	@Test
	void testCheckId_CorrectID() {
		// fail("Not yet implemented");

		ProductCreateService productCreateService = new ProductCreateServiceImpl();

		try {
			productCreateService.checkId(23);
			assertTrue(true);

		} catch (BusinessException e) {
			fail("Exception thrown");
		}

	}
	
	@Test
	void testCheckId_IncorrectID() {
		// fail("Not yet implemented");

		ProductCreateService productCreateService = new ProductCreateServiceImpl();

		try {
			productCreateService.checkId(2332);
			fail("No Exception thrown");

		} catch (BusinessException e) {
			assertTrue(true);
		}

	}


	@Test
	void testCheckPrice_CorrectPrice() {
		
		ProductCreateService productCreateService = new ProductCreateServiceImpl();

		try {
			productCreateService.checkPrice(45322);
			assertTrue(true);

		} catch (BusinessException e) {
			fail("Exception thrown");
		}
		
	}
	
	@Test
	void testCheckPrice_IncorrectPrice() {
		
		ProductCreateService productCreateService = new ProductCreateServiceImpl();

		try {
			productCreateService.checkPrice(-4532);
			fail("No Exception thrown");

		} catch (BusinessException e) {
			assertTrue(true);
			
		}
		
	}

}
