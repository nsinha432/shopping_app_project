package com.product.search.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.product.search.service.ProductSearchService;

class testProductSearchServiceImpl {

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
	void testCheckName_ifCorrect() {
		// fail("Not yet implemented");

		ProductSearchService productSearchService = new ProductSearchServiceImpl();

		try {
			productSearchService.checkName("Mobile");
			assertTrue(true);
		} catch (BusinessException e) {
			fail("Exception thrown");
		}

	}

	@Test
	void testCheckName_ifIncorrect() {
		// fail("Not yet implemented");

		ProductSearchService productSearchService = new ProductSearchServiceImpl();

		try {
			productSearchService.checkName("Mod23fsd2sd");
			fail("No Exception thrown");
		} catch (BusinessException e) {
			assertTrue(true);

		}

	}

	@Test
	void testCheckId_IncorrectID() {
		// fail("Not yet implemented");

		ProductSearchService productSearchService = new ProductSearchServiceImpl();

		try {
			productSearchService.checkId(3343);
			fail("No Exception thrown");
		} catch (BusinessException e) {
			assertTrue(true);

		}

	}
	
	@Test
	void testCheckId_CorrectID() {
		// fail("Not yet implemented");

		ProductSearchService productSearchService = new ProductSearchServiceImpl();

		try {
			productSearchService.checkId(33);
			assertTrue(true);
			
		} catch (BusinessException e) {
			fail("No Exception thrown");

		}

	}

}
