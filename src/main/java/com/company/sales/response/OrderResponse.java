package com.company.sales.response;

import java.util.List;

import com.company.sales.model.Order;

import lombok.Data;

//Create the methods with Lombok
@Data
public class OrderResponse {
	private List<Order> order;
}
