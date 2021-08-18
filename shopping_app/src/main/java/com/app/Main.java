package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCreateDAO;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.CustomerCreateDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.ProductSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.customer.create.service.CustomerCreateService;
import com.customer.create.service.impl.CustomerCreateServiceImpl;
import com.customer.login.service.CustomerLoginService;
import com.customer.login.service.impl.CustomerLoginServiceImpl;
import com.product.search.service.ProductSearchService;
import com.product.search.service.impl.ProductSearchServiceImpl;

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
				log.warn("Please enter a digit between 1 and 4 only");
				continue;
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

					if (c == 1) {
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

				//Customer customer1 = new Customer();

				String email1 = scanner.nextLine();

				try {
					if (customerLoginService.checkEmail(email1)) {
						//customer1.setEmail(email1);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				log.info("2.) Enter password");

				String password1 = scanner.nextLine();

				try {
					if (customerLoginService.checkPassword(password1)) {
						//customer1.setPassword(password1);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					continue;
				}

				try {
					Customer customer2 = customerLoginDAO.loginCustomer(email1, password1);

					if (customer2 != null) {
						log.info("Customer logged in successfully");
						log.info("Hello " + customer2.getFname() + " " + customer2.getLname()+ "\nWhat would you like to do today?");
					}

				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}

				int choice1 = 0;

				do {

					log.info("1.) Search products");
					log.info("2.) View your orders");
					log.info("3.) Logout");

					log.info("\nPlease enter your choice");

					try {
						choice1 = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						log.warn("Please enter a digit between 1 and 3 only");
						continue;
					}

					switch (choice1) {
					case 1:
						int choice2 = 0;
						do {

							log.info("Welcome to Product Search");
							log.info("How would you want to search the products?");

							log.info("1.) By name");
							log.info("2.) By Id");
							log.info("3.) Show all products");
							log.info("4.) Return back to the previous menu");

							log.info("Please enter your choice");

							try {
								choice2 = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								log.warn("Please enter digits between 1 and 4 only");
								continue;
							}
							
							ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
							
							ProductSearchService productSearchService = new ProductSearchServiceImpl();
							
							switch (choice2) {
							case 1:
								log.info("Enter product name: ");
								
								String name = scanner.nextLine();
								
								try {
									if(productSearchService.checkName(name)) {
										
									}
								} catch (BusinessException e1) {
									log.warn(e1.getMessage());
								}
								
								try {
									List<Product> productList = productSearchDAO.getProductsByName(name);
									
									log.info("There are "+productList.size()+" products with the name: "+name);
									log.info("Printing product details");
									
									for(Product product:productList) {
										log.info(product);
									}
									
								} catch (BusinessException e2) {
									log.warn(e2.getMessage());
								}
								

								break;

							case 2:
								log.info("Enter product id");
								int id = 0;
								
								try{
									id = Integer.parseInt(scanner.nextLine());
								}catch(NumberFormatException e) {
									log.warn("Please enter digits only");
									continue;
								}
								
								try {
									if(productSearchService.checkId(id)) {
										
									}
								} catch (BusinessException e1) {
									log.warn(e1.getMessage());
								}
								
								try {
									
									Product product = productSearchDAO.getProductById(id);
									
									log.info("Printing product details with ID : "+id);
									log.info(product);
									
								} catch (BusinessException e1) {
									log.warn(e1.getMessage());
								}
								
								break;

							case 3:
								log.info("All the available products are listed below");
								
								try {
									List<Product> productList = productSearchDAO.getAllProducts();
									for(Product product:productList) {
										log.info(product);
									}
									
								} catch (BusinessException e) {
									log.warn(e.getMessage());
									continue;
								}
								 

								break;

							case 4:
								log.info("Taking you to the previous menu...");
								break;

							default:
								break;
							}

						} while (choice2 != 4);

						break;

					case 2:
						log.info("Under Construction");

						break;

					case 3:
						log.info("Logging you out...");

						break;
					default:
						break;
					}

				} while (choice1 != 3);

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
