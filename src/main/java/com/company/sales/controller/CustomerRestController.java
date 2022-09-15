package com.company.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.sales.model.Customer;
import com.company.sales.response.CustomerResponseRest;
import com.company.sales.services.iCustomerService;

@CrossOrigin(origins = {"127.0.0.1:8080"})
@RestController
@RequestMapping("/api/v1")  //For the use of the api
public class CustomerRestController {
	
	//Instantiate the interface
	@Autowired
	private iCustomerService service;
	
	//Get all the customers
	@GetMapping("/customers")
	public ResponseEntity<CustomerResponseRest> FindAllCustomer(){
		ResponseEntity<CustomerResponseRest> response = service.search();  //We call it the search() method
		return response;
	}
	
	//Get customers by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerResponseRest> FindOneCustomer(@PathVariable Integer id){
		ResponseEntity<CustomerResponseRest> response = service.searchById(id);  //We call it the searchById() method
		return response;
	}
	
	//Save customers
	@PostMapping("/customers")
	public ResponseEntity<CustomerResponseRest> SaveCustomer(@RequestBody Customer customer){
		ResponseEntity<CustomerResponseRest> response = service.save(customer);  //We call it the save() method
		return response;
	}
	
	//Update customers
	@PutMapping("/customers/{id}")
	public ResponseEntity<CustomerResponseRest> UpdateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
		ResponseEntity<CustomerResponseRest> response = service.update(customer,id);  //We call it the update() method
		return response;
	}
	
	
	//Delete customers
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<CustomerResponseRest> deleteCustomer(@PathVariable Integer id){
		ResponseEntity<CustomerResponseRest> response = service.deleteById(id);  //We call it the deleteById() method
		return response;
	}
	
	
}
