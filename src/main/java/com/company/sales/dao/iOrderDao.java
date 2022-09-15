package com.company.sales.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.sales.model.Order;


public interface iOrderDao extends CrudRepository<Order, Integer>{
	//Methods to access the data
}
