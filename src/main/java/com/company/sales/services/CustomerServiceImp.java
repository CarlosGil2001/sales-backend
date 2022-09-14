package com.company.sales.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	
	//Método mostrar todos los customers
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

	
	//Método para buscar por id 
	@Override
	@Transactional() //Declarar el método como "método trasancional"
	public ResponseEntity<CustomerResponseRest> searchById(Integer id) {
		
		//Instanciar objeto
		CustomerResponseRest response = new CustomerResponseRest();
		List<Customer> list = new ArrayList<>();
				
			//Manejar errores
			try {
				
				Optional<Customer> customer = customerDao.findById(id);
				//Si el objeto existe
				if(customer.isPresent()) 
				{
					list.add(customer.get());
					response.getCustomerRespose().setCustomer(list);
					response.setMetadata("Respuesta fallida", "00", "ERROR");

				}
				//En caso contrario
				else
				{
					response.setMetadata("Respuesta fallida", "-1", "ERROR");
					return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.NOT_FOUND);	
				}
				
					
			} catch(Exception e) {
					
				//En caso de error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Retornar respuesta
			return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.OK);
	}


	//Método guardar customer 
	@Override
	@Transactional() //Declarar el método como "método trasancional"
	public ResponseEntity<CustomerResponseRest> save(Customer customer) {
		
		//Instanciar objeto
		CustomerResponseRest response = new CustomerResponseRest();
		List<Customer> list = new ArrayList<>();
				
			//Manejar errores
			try {
				
				Customer customerSaved = customerDao.save(customer);
				
				//Si hay respuesta
				if(customerSaved != null)
				{
					//Guardamos
					list.add(customerSaved);
					response.getCustomerRespose().setCustomer(list);
				}
				//En caso contrario
				else
				{
					response.setMetadata("Respuesta fallida", "-1", "ERROR");
					return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
				
					
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
