package com.company.sales.services;

import org.springframework.http.ResponseEntity;

import com.company.sales.response.CustomerResponseRest;

public interface iCustomerService {
	
	//Interfaces search();
	public ResponseEntity<CustomerResponseRest> search();
	
	//Método para customer por id
	public ResponseEntity<CustomerResponseRest> searchById(Integer id);

}
