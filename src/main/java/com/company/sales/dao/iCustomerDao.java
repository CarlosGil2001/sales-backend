package com.company.sales.dao;

import com.company.sales.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface iCustomerDao extends CrudRepository<Customer, Integer>{
	
	//Methods to access the data

}
