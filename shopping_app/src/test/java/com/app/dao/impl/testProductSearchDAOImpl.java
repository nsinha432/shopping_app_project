package com.app.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.dao.ProductSearchDAO;
import com.app.exception.BusinessException;
import com.app.model.Product;

class testProductSearchDAOImpl {

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

/*	@Test
	void testGetProductsByName() {
		fail("Not yet implemented");
	}
*/
	@Test
	void testGetProductById_SameID() {
		//fail("Not yet implemented");
		
		Product product = new Product(2, "Mobile", 12000);
		
		ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
		
		try {
			Product product2 = productSearchDAO.getProductById(2);
			assertEquals(product, product2, "Incorrect Selection");
		} catch (BusinessException e) {
			
			fail("Exception thrown");
		}
		
		
	}
	
	@Test
	void testGetProductById_DifferentID(){
		//fail("Not yet implemented");
		
		Product product = new Product(2, "Mobile", 12000);
		
		ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
		
		try {
			Product product2 = productSearchDAO.getProductById(3);
			assertNotEquals(product, product2, "Correct Selection");
		} catch (BusinessException e) {
			
			fail("Exception thrown");
		}
		
		
	}

/*	@Test
	void testGetAllProducts() {
		fail("Not yet implemented");
	}
*/
}
