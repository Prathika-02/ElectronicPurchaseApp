package com.cg.elecpurchapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.elecpurchapp.domain.Customer;
import com.cg.elecpurchapp.service.CustomerService;
import com.cg.elecpurchapp.service.MapValidationErrorService;

/**
 * A rest controller which handles all the URL request given by the application for various services.
 * @author Cheerala Prathika
 *
 */

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	

	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	/**
	 * Handles the request for storing the data of the new customer.
	 * 
	 */
	@PostMapping("")
	public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer, BindingResult result)
	{
		ResponseEntity<?> errorMap = MapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		Customer newCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}
	/**
	 * Handles the request for getting the customer data based on identifier.
	 * 
	 */
	
	@GetMapping("/{identifier}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable String identifier) throws Exception{
		Customer customer=customerService.findByIdentifier(identifier);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	/**
	 * Handles the request for showing the data of all the customera.
	 * @return the iterable of type customers.
	 */
	@GetMapping("/all")
	public Iterable<Customer> showAllCustomers(){
		return customerService.findAll();
	}
	/**
	 * Handles the request for deleting the customer in the database with the given identifier.
	 * 
	 */
	@DeleteMapping("/{identifier}")
	public ResponseEntity<?> deleteCustomer(@PathVariable String identifier){
		customerService.deleteCustomer(identifier);
		return new ResponseEntity<String> ("Customer with Id : "+identifier.toUpperCase()+" Deleted!",HttpStatus.OK);
	}
	
	/*@PostMapping("")
	public ResponseEntity<Customer> addCustomer( @RequestBody Customer customer)
	{
		
		Customer newCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}*/
		
}

