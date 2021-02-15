package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;

@RestController
public class CustomerController {

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerRepository repository;

	@GetMapping("/add/customers")
	public void addCustomers() {
		// save a few customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
	}

	@GetMapping("/fetch/customer/all")
	public void fetchAllCustomers() {
		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
	}

	@GetMapping("/fetch/customer/id")
	public void fetchCustomers(long id) {
		Customer customer = repository.findById(1L);
		log.info("Customer found with findById(1L):");
		log.info("--------------------------------");
		log.info(customer.toString());
	}

	@GetMapping("/fetch/customer/lastname")
	public void fetchCustomers(String lastname) {
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		repository.findByLastName(lastname).forEach(bauer -> {
			log.info(bauer.toString());
		});
	}

}
