package com.company.sales.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.sales.dao.iCustomerDao;
import com.company.sales.model.Customer;
import com.company.sales.response.CustomerResponseRest;

//Indicar que es una clase de servicio
@Service

//Implementación
public class CustomerServiceImp implements iCustomerService{
	
	@Autowired  //Injectar este objeto para usarlo en spring
	private iCustomerDao customerDao;
	
	
	@Override
	@Transactional() //Declarar el método como "método trasancional"
	
	
	public ResponseEntity<CustomerResponseRest> search() {
		
		//Instanciar objeto
		CustomerResponseRest response = new CustomerResponseRest();
		
		//Manejar errores
		try {
			
			List<Customer> customer = (List<Customer>) customerDao.findAll();
			response.getCustomerRespose().setCustomer(customer); //Setter la lista de todas los customer
			response.setMetadata("Respuesta Ok", "00", "Respuesta exitosa"); //llenamos el metadata
			
		} catch(Exception e) {
			
			//En caso de error
			response.setMetadata("Respuesta fallida", "-1", "ERROR");
			e.getStackTrace();
			return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		//Retornar respuesta
		return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.OK);
	}

}
