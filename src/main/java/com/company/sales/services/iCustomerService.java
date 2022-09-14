package com.company.sales.services;

import org.springframework.http.ResponseEntity;

import com.company.sales.model.Customer;
import com.company.sales.response.CustomerResponseRest;

public interface iCustomerService {
	
	//Método para buscar los customers;
	public ResponseEntity<CustomerResponseRest> search();
	
	//Método para customer por id
	public ResponseEntity<CustomerResponseRest> searchById(Integer id);
	
	//Método para guardar
	public ResponseEntity<CustomerResponseRest> save(Customer customer);
}
