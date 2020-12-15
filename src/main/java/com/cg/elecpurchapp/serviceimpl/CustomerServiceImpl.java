package com.cg.elecpurchapp.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.elecpurchapp.domain.Customer;
import com.cg.elecpurchapp.exception.CustomerNotFoundException;
import com.cg.elecpurchapp.repository.CustomerRepository;
import com.cg.elecpurchapp.service.CustomerService;

/**
 * A class which provides all services of customer
 * @author Cheerala Prathika
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Stores the customer related data inside the database.
	 * @param customer
	 * 
	 */
	
	@Override
	public Customer addCustomer(Customer customer)  {
		try {
			customer.setIdentifier(customer.getIdentifier().toUpperCase());
			return customerRepository.save(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException();
		}
	}
	
	/**
	 * Find the customer in database based on identifier.
	 * @param identifier
	 *.
	 */
	
	@Override
	public Customer findByIdentifier(String identifier) {
		Customer customer=null;
		Optional<Customer> optionalCustomer =  customerRepository.findByIdentifier(identifier);
		if(optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
		} else {
			throw new CustomerNotFoundException();
		}
		return customer;
	}


	@Override
	public <OngoingStubbing> List<Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();

	}

	/**
	 * Retrieves all the customer related data from the database.
	 * @return the iterable of customers.
	 */
	@Override
	public Iterable<Customer> showAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();
	}

	/**
	 * Delete the customer data in database based on customer identifier.
	 * @param identifier
	 */

	@Override
	public void deleteCustomer(String identifier) {
		// TODO Auto-generated method stub
		Customer customer=findByIdentifier(identifier);
		if(customer==null) {
			throw new CustomerNotFoundException();
		}
		customerRepository.delete(customer);
		 
	}

	@Override
	public Object updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return null;
	}

	
}

	

	


	


	

	

	

	

	
	

	


