package com.cg.elecpurchapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.elecpurchapp.domain.Customer;
import com.cg.elecpurchapp.exception.CustomerNotFoundException;
import com.cg.elecpurchapp.repository.CustomerRepository;
import com.cg.elecpurchapp.serviceimpl.CustomerServiceImpl;

/**
 * A class to test various methods of service
 * @author Cheerala Prathika
 *
 */
class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Testing the findByIdentifier method of the service layer on giving correct inputs.
	 */
	
	@Test
	void test_viewCustomer() throws Exception{
		BDDMockito.given(customerRepository.findByIdentifier("102")).willReturn(Optional.of(new Customer("102","Radha","radha@gmail.com","7660881766","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889")));
		Customer customer=customerServiceImpl.findByIdentifier("102");
		assertNotNull(customer);
		assertEquals("102", customer.getIdentifier());
		assertEquals("Radha", customer.getName());
		assertEquals("radha@gmail.com", customer.getEmail());
		assertEquals("7660881766", customer.getPhone());
		assertEquals("Hno-103", customer.getAddressLineOne());
		assertEquals("Fathenagar", customer.getAddressLineTwo());
		assertEquals("Hyderabad", customer.getCity());
		assertEquals("Telangana", customer.getlState());
		//assertEquals("India", customer.getCountry());
		assertEquals("68889", customer.getPostalCode());
		
	}
	
	/**
	 * Testing the findByIdentifier method of the service layer when customerRepository findByIdentifier throws customer not found exception.
	 */
	@Test
	void test_viewCustomer_ThrowCustomerException() {
		BDDMockito.given(customerRepository.findByIdentifier("103")).willThrow(new CustomerNotFoundException());
		assertThrows(CustomerNotFoundException.class, ()->customerServiceImpl.findByIdentifier("103"));
		
	}
	/**
	 * Testing the save method of service class by giving correct inputs.
	 */
	@Test
	void test_addCustomer() {
		Customer customer=new Customer("101","Prathika","prathika@gmail.com","9247847122","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889");
		when(customerRepository.save(customer)).thenReturn(customer);
		Object result=customerRepository.save(customer);
		assertEquals("101",((Customer) result).getIdentifier());
		assertEquals("Prathika",((Customer) result).getName());
		assertEquals("prathika@gmail.com",((Customer) result).getEmail());
		assertEquals("9247847122",((Customer) result).getPhone());
	}

	/**
	 * Testing the findAllCustomers method of the service layer by assigning the correct return value to customerRepository  findAll method.
	 */
	
	@Test
	public void test_showAllCustomers() {
		List<Customer> customerList=new ArrayList<Customer>();
		customerList.add(new Customer("101","Prathika","prathika@gmail.com","9247847122","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889"));
		customerList.add(new Customer("102","Radha","radha@gmail.com","7660881766","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889"));
		customerList.add(new Customer("103","Teena","teena@gmail.com","9246530559","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889"));
		Mockito.when(customerRepository.findAll()).thenReturn(customerList);
		
	}
	
	
	
	
	
	
	
	
	
//	@Test
//	void  test_deleteCustomer(){
//		Optional<Customer> customer=Optional.of(new Customer("103","Akhila","akhila@gmail.com","9246547122"));
//		Mockito.when(customerRepository.findByIdentifier("103")).thenReturn(customer);
//		 result=customerServiceImpl.deleteCustomer("103");
//		assertThat(result);
//		
//	}

}
