package com.company.sales.response;

import java.util.List;

import com.company.sales.model.Customer;

import lombok.Data;

//Create the methods with Lombok
@Data
public class CustomerResponse {
	private List<Customer> customer;
}
