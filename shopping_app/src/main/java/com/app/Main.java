package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCreateDAO;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.impl.CustomerCreateDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.customer.create.service.CustomerCreateService;
import com.customer.create.service.impl.CustomerCreateServiceImpl;
import com.customer.login.service.CustomerLoginService;
import com.customer.login.service.impl.CustomerLoginServiceImpl;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		log.info("Welcome to shopping app");
		log.info("-------------------------------");

		int choice = 0;

		do {

			log.info("Please login: ");
			log.info("\n1.) Associate Login");
			log.info("2.) Customer Registration");
			log.info("3.) Customer Login");
			log.info("4.) Close App");

			log.info("\n Please enter your choice: ");

			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}

			switch (choice) {
			case 1:
				log.info("Under Construction");

				break;

			case 2:
				log.info("Enter customer details for creation :\n");

				CustomerCreateService customerCreateService = new CustomerCreateServiceImpl();
				CustomerCreateDAO customerCreateDAO = new CustomerCreateDAOImpl();

				Customer customer = new Customer();

				log.info("1.) Enter email");

				String email = scanner.nextLine();

				try {
					if (customerCreateService.checkEmail(email)) {
						customer.setEmail(email);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				log.info("2.) Enter first name");

				String fname = scanner.nextLine();

				try {
					if (customerCreateService.checkFname(fname)) {
						customer.setFname(fname);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				log.info("3.) Enter last name");

				String lname = scanner.nextLine();

				try {
					if (customerCreateService.checkLname(lname)) {
						customer.setLname(lname);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}
				
				log.info("4.) Enter password");
				
				String password = scanner.nextLine();
				
				try {
					if (customerCreateService.checkPassword(password)) {
						customer.setPassword(password);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}
				
				try {
					int c = customerCreateDAO.createCustomer(customer);
					
					if(c==1) {
						log.info("Customer created Successfully");
					}
					
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				
				

				break;

			case 3:
				log.info("Enter customer login details: ");
				
				log.info("1.) Enter email");
				
				CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
				CustomerLoginDAO customerLoginDAO = new CustomerLoginDAOImpl();
				
				Customer customer1 = new Customer();
				
				String email1 = scanner.nextLine();
				
				try {
					if (customerLoginService.checkEmail(email1)) {
						customer1.setEmail(email1);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}
				
				log.info("2.) Enter password");
				
				String password1 = scanner.nextLine();
				

				try {
					if (customerLoginService.checkPassword(password1)) {
						customer1.setPassword(password1);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}
				
				try {
					Customer customer2 = customerLoginDAO.loginCustomer(email1, password1);
					
					if(customer2 != null) {
						log.info("Customer logged in successfully");
						log.info("Hello "+customer2.getFname()+" "+ customer2.getLname()+" What would you like to do today?");
					}
					
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				

				break;

			case 4:
				log.info("Thanks for shopping with us! Hope to see you soon :)");

				break;

			default:
				log.warn("Invalid choice! The choice should only be a number between 1-4. Please try again.");
				break;

			}

		} while (choice != 4);

	}
}