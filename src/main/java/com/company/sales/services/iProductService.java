package com.company.sales.services;

import org.springframework.http.ResponseEntity;

import com.company.sales.model.Product;
import com.company.sales.response.ProductResponseRest;

public interface iProductService {

	//Method list products
	public ResponseEntity<ProductResponseRest> search();
	
	//Method for product by id
	public ResponseEntity<ProductResponseRest> searchById(Integer id);
	
	//Method to save
	public ResponseEntity<ProductResponseRest> save(Product product);
	
	//Method to update
	public ResponseEntity<ProductResponseRest> update(Product product, Integer id);
	
	//Method to delete (update status)
	public ResponseEntity<ProductResponseRest> searchById(Product product,Integer id);
}
