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

@CrossOrigin(origins = {"http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api/v1")  //Para el uso de las apis
public class CustomerRestController {
	
	//Instanciar la interface
	@Autowired
	private iCustomerService service;
	
	//Get all the customers
	@GetMapping("/customers")
	public ResponseEntity<CustomerResponseRest> FindAllCustomer(){
		ResponseEntity<CustomerResponseRest> response = service.search();  //Llamamos el método search()
		return response;
	}
	
	//Get customers by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerResponseRest> FindOneCustomer(@PathVariable Integer id){
		ResponseEntity<CustomerResponseRest> response = service.searchById(id);  //Llamamos el método searchById()
		return response;
	}
	
	//Save customers
	@PostMapping("/customers")
	public ResponseEntity<CustomerResponseRest> SaveCustomer(@RequestBody Customer customer){
		ResponseEntity<CustomerResponseRest> response = service.save(customer);  //Llamamos el método save()
		return response;
	}
	
	//Update customers
	@PutMapping("/customers/{id}")
	public ResponseEntity<CustomerResponseRest> UpdateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
		ResponseEntity<CustomerResponseRest> response = service.update(customer,id);  //Llamamos el método update()
		return response;
	}
	
	
	//Delete customers
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<CustomerResponseRest> deleteCustomer(@PathVariable Integer id){
		ResponseEntity<CustomerResponseRest> response = service.deleteById(id);  //Llamamos el método deleteById()
		return response;
	}
	
	
}
