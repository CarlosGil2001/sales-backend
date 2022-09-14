package com.company.sales.response;


import lombok.Getter;
import lombok.Setter;

//Utilizamos Lombok para Getter y Setter
@Getter
@Setter

//Heredamos la clase ResponseRest
public class CustomerResponseRest extends ResponseRest{
	
	//Instanciamos
	private CustomerResponse customerRespose = new CustomerResponse();
	
}
