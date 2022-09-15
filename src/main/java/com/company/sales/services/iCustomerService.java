package com.company.sales.services;

import org.springframework.http.ResponseEntity;

import com.company.sales.model.Customer;
import com.company.sales.response.CustomerResponseRest;

public interface iCustomerService {
	
	//Method list clients
	public ResponseEntity<CustomerResponseRest> search();
	
	//Method for client by id
	public ResponseEntity<CustomerResponseRest> searchById(Integer id);
	
	//Method to save
	public ResponseEntity<CustomerResponseRest> save(Customer customer);
	
	//Method to Update
	public ResponseEntity<CustomerResponseRest> update(Customer customer, Integer id);
	
	//Method to Delete
	public ResponseEntity<CustomerResponseRest> deleteById(Integer id);
}
