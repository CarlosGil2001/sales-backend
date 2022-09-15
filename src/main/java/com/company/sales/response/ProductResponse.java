package com.company.sales.response;

import java.util.List;

import com.company.sales.model.Product;

import lombok.Data;

//Create the methods with Lombok
@Data
public class ProductResponse {
	private List<Product> product;
}
