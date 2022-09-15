package com.company.sales.response;

import lombok.Getter;
import lombok.Setter;

//We use Lombok for Getter and Setter
@Getter
@Setter

//We inherit the ResponseRest class
public class ProductResponseRest extends ResponseRest{
	
	// instantiate
	private ProductResponse productResponse = new ProductResponse();
	
}