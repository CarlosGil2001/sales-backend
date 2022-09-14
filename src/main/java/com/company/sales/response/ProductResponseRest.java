package com.company.sales.response;

import lombok.Getter;
import lombok.Setter;

//Utilizamos Lombok para Getter y Setter
@Getter
@Setter

//Heredamos la clase ResponseRest
public class ProductResponseRest extends ResponseRest{
	
	//Instanciamos
	private ProductResponse productResponse = new ProductResponse();
	
}