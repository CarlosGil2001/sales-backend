package com.company.sales.dao;

import com.company.sales.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface iCustomerDao extends CrudRepository<Customer, Integer>{
	
	//Métodos para acceder a los datos

}
