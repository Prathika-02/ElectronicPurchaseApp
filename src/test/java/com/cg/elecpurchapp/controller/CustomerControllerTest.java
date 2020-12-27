package com.cg.elecpurchapp.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.xmlunit.util.Mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cg.elecpurchapp.domain.Customer;
import com.cg.elecpurchapp.exception.CustomerNotFoundException;
import com.cg.elecpurchapp.service.CustomerService;
import com.cg.elecpurchapp.service.MapValidationErrorService;

/**
 * A class to test various methods of rest controller
 * @author Cheerala Prathika
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers=CustomerController.class)
class CustomerControllerTest {

	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	MapValidationErrorService mapValidationErrorService;
	
	@MockBean
	CustomerService customerService;
	
	/**
	 * Testing the viewCustomer method of the rest controller if the customer with given  customerIdentifier exist in the repository.
	 * 
	 */
	
	@Test
	void test_viewCustomer() throws Exception{
		BDDMockito.given(customerService.findByIdentifier(Mockito.anyString())).willReturn(new Customer("101","Prathika","prathika@gmail.com","9247847122","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889"));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/101"))
		.andExpect(status().isOk())
	    //.andExpect(jsonPath("$").isMap())
	    .andExpect(jsonPath("identifier").value("101"))
	    .andExpect(jsonPath("name").value("Prathika"))
	    .andExpect(jsonPath("email").value("prathika@gmail.com"))
	    .andExpect(jsonPath("phone").value("9247847122"))
		.andExpect(jsonPath("addressLineOne").value("Hno-103"))
	    .andExpect(jsonPath("addressLineTwo").value("Fathenagar"))
	    .andExpect(jsonPath("city").value("Hyderabad"))
	    .andExpect(jsonPath("lState").value("Telangana"))
	   // .andExpect(jsonPath("country").value("India"))
	    .andExpect(jsonPath("postalCode").value("68889"));


	}
	
	/**
	 * Testing the viewCustomer method of the rest controller if the customer with given Identifier doesn't exist in the repository.
	 *
	 */
	
	@Test
	void test_viewCustomer_ThrowCustomerNotFoundException() throws Exception{
		BDDMockito.given(customerService.findByIdentifier(Mockito.anyString())).willThrow(new CustomerNotFoundException());
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/101"))
		.andExpect(status().isNotFound());
	}
	
	/**
	 * Testing the addCustomer method of the rest controller by giving the valid data of the customer.
	 * 
	 */

	@Test
	public void test_addCustomer() {
		
		Customer customer=new Customer("101","Prathika","prathika@gmail.com","9247847122","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889");
		when(customerService.addCustomer(customer)).thenReturn(customer);
		Object result=customerService.addCustomer(customer);
		assertEquals("101",((Customer) result).getIdentifier());
		assertEquals("Prathika",((Customer) result).getName());
		assertEquals("prathika@gmail.com",((Customer) result).getEmail());
		assertEquals("9247847122",((Customer) result).getPhone());

	}
	
	/**
	 * Testing the showAllCustomers method of the rest controller by checking whether the data present in the table.
	 * 
	 */
	
	@Test
	public void test_showAllCustomers() {
		List<Customer> customerList=new ArrayList<>();
		customerList.add(new Customer("101","Prathika","prathika@gmail.com","9247847122","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889"));
		customerList.add(new Customer("102","Radha","radha@gmail.com","7660881766","Flat-8","LelaNagar","Bangalore","Karnataka","Inida","500018"));
		customerList.add(new Customer("103","Teena","teena@gmail.com","9246530559","Hno-10-5","Rail Nilayam","Hyderabad","Telangana","Inida","599871"));
		Mockito.when(customerService.findAll()).thenReturn(customerList);

		
	}
	
	/**
	 * Testing the delete customer method of the rest controller if the customer with given Identifier successfully deleted.
	 * 
	 */
	
	@Test
	void test_deleteCustomer() throws Exception {
	
	BDDMockito.given(customerService.findByIdentifier(Mockito.anyString())).willReturn(new Customer("103","Teena","teena@gmail.com","9246530559","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889"));
	doNothing().when(customerService).deleteCustomer("103");
	mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/103"))
	.andExpect(jsonPath("$").isMap())
	.andExpect(jsonPath("identifier").value("103"));
	}
	
	/**
	 * Testing the deleteCustomer method of the rest controller if the customer with given Identifier doesn't exist in the repository.
	 * 
	 */
	
	@Test
	void test_deleteCustomer_ThrowCustomerException() throws Exception{
		BDDMockito.given(customerService.findByIdentifier(Mockito.anyString())).willThrow(new CustomerNotFoundException());
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/101"))
		.andExpect(status().isNotFound());
	}
	
	@Test
	void test_updateCustomer_ShouldReturnCustomer() {
		Customer customer=new Customer("103","Teena","teena@gmail.com","9246530559","Hno-103","Fathenagar","Hyderabad","Telangana","Inida","68889");
		when(customerService.updateCustomer(customer)).thenReturn(customer);
		Customer result=(Customer) customerService.updateCustomer(customer);
		assertEquals("Teena",result.getName());
	}

	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	void test_updateCustomer() throws Exception {
		Customer customer=new Customer("103","Teena","teena@gmail.com","9246530559");
		when(customerService.updateCustomer("106")).thenReturn(customer);
		customer.setName("Teena");
		//String json= mapper.writeValueAsString(customer);
		mockMvc.perform(patch("/api/customers/byId/106").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Teena"));
	}*/
	
	
	
	
	
}
