package com.company.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.sales.response.CustomerResponseRest;
import com.company.sales.services.iCustomerService;

@RestController
@RequestMapping("/api/v1")  //Para el uso de las apis
public class CustomerRestController {
	
	//Instanciar la interface
	@Autowired
	private iCustomerService service;
	
	//Get all the customers
	@GetMapping("/customers")
	public ResponseEntity<CustomerResponseRest> FindAllCustomer(){
		ResponseEntity<CustomerResponseRest> response = service.search();  //Llamamos el método seacrh()
		return response;
	}
	
	//Get customers by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerResponseRest> FindOneCustomer(@PathVariable Integer id){
		ResponseEntity<CustomerResponseRest> response = service.searchById(id);  //Llamamos el método searchById()
		return response;
	}
}
