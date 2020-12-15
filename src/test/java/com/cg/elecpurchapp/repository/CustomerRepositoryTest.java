package com.cg.elecpurchapp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.elecpurchapp.domain.Customer;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	/**
	 * Test the findByIdentifier method of customerRepository if the customer exist.
	 * @throws Exception
	 */
	@Test
	void test_viewCustomer() throws Exception{
		System.out.println("---------------->"+customerRepository);
		Optional<Customer> customer= customerRepository.findByIdentifier("101");
		assertFalse(customer.isPresent());
		
	}
	/**
	 * Testing the add method of repository by giving correct inputs.
	 */
	@Test
	void test_addCustomer() {
		Customer customer=new Customer("103","Teena","teena@gmail.com","9246530559");
		Customer newCustomer=customerRepository.save(customer);
		assertEquals("103",newCustomer.getIdentifier());
	}
	/**
	 * Testing the update method of repository by updating the values.
	 */
	
	@Test
	void test_updateCustomer() {
		Customer customer=new Customer("103","Teena","teena@gmail.com","9246530559");
		Customer newCustomer=customerRepository.save(customer);
		assertEquals("Teena",newCustomer.getName());
	}
	/**
	 * Testing the showAll method of repository displaying all the customers.
	 */
	@Test
	void test_ShowAllCustomers() {
		Customer customer1=new Customer("101","Prathika","prathika@gmail.com","9247847122");
		Customer customer2=new Customer("102","Ram","ram@gmail.com","9848654212");
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		assertNotNull(customerRepository.findAll());
		}
	
	
	
}
