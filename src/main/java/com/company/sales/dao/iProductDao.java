package com.company.sales.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.sales.model.Product;


public interface iProductDao extends CrudRepository<Product, Integer>{
	
	//Methods to access the data

}