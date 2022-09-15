package com.company.sales.services;

import org.springframework.http.ResponseEntity;

import com.company.sales.response.ProductResponseRest;

public interface iProductService {

	//Método para buscar los customers;
	public ResponseEntity<ProductResponseRest> search();
	
	//Método para product por id
	public ResponseEntity<ProductResponseRest> searchById(Integer id);
	
}
