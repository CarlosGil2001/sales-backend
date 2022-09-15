package com.company.sales.services;

import org.springframework.http.ResponseEntity;

import com.company.sales.model.Product;
import com.company.sales.response.CustomerResponseRest;
import com.company.sales.response.ProductResponseRest;

public interface iProductService {

	//Método para buscar los customers;
	public ResponseEntity<ProductResponseRest> search();
	
	//Método para product por id
	public ResponseEntity<ProductResponseRest> searchById(Integer id);
	
	//Método para guardar
	public ResponseEntity<ProductResponseRest> save(Product product);
	
	//Método para Actualizar
	public ResponseEntity<ProductResponseRest> update(Product product, Integer id);
	
	//Método para Eliminar (Cambiar status)
	public ResponseEntity<ProductResponseRest> searchById(Product product,Integer id);
}
