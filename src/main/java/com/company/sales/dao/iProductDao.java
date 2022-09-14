package com.company.sales.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.sales.model.Product;


public interface iProductDao extends CrudRepository<Product, Integer>{
	
	//Métodos para acceder a los datos

}