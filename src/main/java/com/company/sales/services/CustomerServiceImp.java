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

//Indicate that it is a service class
@Service

//Implementation
public class CustomerServiceImp implements iCustomerService{
	
	@Autowired  //Inject this object to use in spring
	private iCustomerDao customerDao;
	
	
	// Show all clients method
	@Override
	@Transactional() //Declare the method as "transactional method"
	
	
	public ResponseEntity<CustomerResponseRest> search() {
		
		//instantiate object
		CustomerResponseRest response = new CustomerResponseRest();
		
		//handle errors
		try {
			
			List<Customer> customer = (List<Customer>) customerDao.findAll();
			response.getCustomerRespose().setCustomer(customer); // Set the list of all clients
			response.setMetadata("Respuesta exitosa", "00", "CORRECT"); //fill the metadata
			
		} catch(Exception e) {
			
			//In case of error
			response.setMetadata("Respuesta fallida", "-1", "ERROR");
			e.getStackTrace();
			return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		//Return response
		return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.OK);
	}

	
	//Method to search by id
	@Override
	@Transactional() //Declare the method as "transactional method"
	public ResponseEntity<CustomerResponseRest> searchById(Integer id) {
		
		//Instantiate object
		CustomerResponseRest response = new CustomerResponseRest();
		List<Customer> list = new ArrayList<>();
				
		//Handling errors
			try {
				
				Optional<Customer> customer = customerDao.findById(id);
				//if the object exists
				if(customer.isPresent()) 
				{
					list.add(customer.get());
					response.getCustomerRespose().setCustomer(list);
					response.setMetadata("Respuesta exitosa", "00", "CORRECT");

				}
				//Otherwise
				else
				{
					response.setMetadata("Respuesta fallida", "-1", "ERROR");
					return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.NOT_FOUND);	
				}
				
					
			} catch(Exception e) {
					
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Return response
			return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.OK);
	}


	//Save client method
	@Override
	@Transactional() //Declare the method as "transactional method"
	public ResponseEntity<CustomerResponseRest> save(Customer customer) {
		
		//Instantiate object
		CustomerResponseRest response = new CustomerResponseRest();
		List<Customer> list = new ArrayList<>();
				
			//Handling errors
			try {
				
				Customer customerSaved = customerDao.save(customer);
				
				//if there is response
				if(customerSaved != null)
				{
					// We save
					list.add(customerSaved);
					response.getCustomerRespose().setCustomer(list);
					response.setMetadata("Respuesta exitosa", "00", "CORRECT");
				}
				//Otherwise
				else
				{
					response.setMetadata("Respuesta fallida", "-1", "ERROR");
					return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
				
					
			} catch(Exception e) {
					
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Return response
			return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.OK);
	}


	//Update method
	@Override
	@Transactional() //Declare the method as "transactional method"	
	public ResponseEntity<CustomerResponseRest> update(Customer customer, Integer id) {
		
		//Instantiate object
		CustomerResponseRest response = new CustomerResponseRest();
		List<Customer> list = new ArrayList<>();
						
			//Handling errors
			try {
				// Update with the id		
				Optional<Customer> customerSearch = customerDao.findById(id);
				
				//If the id is found, update
				if(customerSearch.isPresent()) 
				{
					customerSearch.get().setNameCustomer(customer.getNameCustomer());
					customerSearch.get().setLastNameCustomer(customer.getLastNameCustomer());
					customerSearch.get().setCityCustomer(customer.getCityCustomer());
					
					//Update in the DB
					Customer customerToUpdate = customerDao.save(customerSearch.get());
					
					//If find the id
					if(customerToUpdate != null)
					{
						list.add(customerToUpdate);
						response.getCustomerRespose().setCustomer(list);
						response.setMetadata("Respuesta exitosa", "00", "CORRECT");
					}
					//Otherwise
					else
					{
						response.setMetadata("Respuesta fallida", "-1", "ERROR");
						return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.BAD_REQUEST);
					}
				}
				else
				{
					response.setMetadata("Respuesta fallida", "-1", "ERROR");
					return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.NOT_FOUND);
				}		
							
			} catch(Exception e) {
							
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
						
			//Return response
			return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.OK);
	}


	//Delete method
	@Override
	@Transactional() //Declare the method as "transactional method"
	public ResponseEntity<CustomerResponseRest> deleteById(Integer id) {
		
		//Instantiate object
		  CustomerResponseRest response = new CustomerResponseRest();
				
		  	//Handle errors
			try {
					
				customerDao.deleteById(id);
				response.setMetadata("Respuesta exitosa", "00", "CORRECT");
					
			} catch(Exception e) {
					
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Return response
			return new ResponseEntity<CustomerResponseRest>(response, HttpStatus.OK);
	}

}
