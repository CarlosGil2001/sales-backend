package com.company.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.sales.response.CustomerResponseRest;
import com.company.sales.response.ProductResponseRest;
import com.company.sales.services.iProductService;

@CrossOrigin(origins = {"http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api/v2")  //Para el uso de las apis

public class ProductRestController {

	    //Instanciar la interface
		@Autowired
		private iProductService service;
		
		//Get all the products
		@GetMapping("/products")
		public ResponseEntity<ProductResponseRest> FindAllProducts(){
			ResponseEntity<ProductResponseRest> response = service.search();  //Llamamos el método search()
			return response;
		}
		
		//Get product by id
		@GetMapping("/products/{id}")
		public ResponseEntity<ProductResponseRest> FindOneCustomer(@PathVariable Integer id){
			ResponseEntity<ProductResponseRest> response = service.searchById(id);  //Llamamos el método searchById()
			return response;
		}
}
