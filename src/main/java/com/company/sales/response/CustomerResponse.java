package com.company.sales.response;

import java.util.List;

import com.company.sales.model.Customer;

import lombok.Data;

//Crear los métodos con Lombok
@Data
public class CustomerResponse {
	private List<Customer> customer;
}
