package kh.com.kshrd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.kshrd.entities.Customer;

@Controller
@RequestMapping(value="/customers")
public class CustomerController {

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerCode("00001");
		customer.setCustomerEmail("darapenhchet@gmail.com");
		customer.setCustomerName("Dara Penhchet");
		customer.setCustomerPhone("086961919");
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerCode("00001");
		customer.setCustomerEmail("darapenhchet@gmail.com");
		customer.setCustomerName("Dara Penhchet");
		customer.setCustomerPhone("086961919");
		customers.add(customer);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	  
}
