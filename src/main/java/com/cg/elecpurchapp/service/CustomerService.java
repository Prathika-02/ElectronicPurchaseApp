package com.cg.elecpurchapp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.elecpurchapp.domain.Customer;

public interface CustomerService {

	Customer findByIdentifier(String identifier);
	
	public Iterable<Customer> showAllCustomers();

	<OngoingStubbing> List<Customer> findAll();

	void deleteCustomer(String identifier);

	Customer addCustomer(Customer customer);

	Object updateCustomer(Customer customer);








}
