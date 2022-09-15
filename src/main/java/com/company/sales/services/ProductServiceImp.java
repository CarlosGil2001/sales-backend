package com.company.sales.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.sales.dao.iProductDao;
import com.company.sales.model.Product;
import com.company.sales.response.ProductResponseRest;

//Indicate that it is a service class
@Service
public class ProductServiceImp implements iProductService{

	@Autowired  //Inject this object to use in spring
	private iProductDao productDao;
	
	
	// Show all products method
	@Override
	@Transactional() //Declare the method as "transactional method"

	public ResponseEntity<ProductResponseRest> search() {
		
		//Instantiate object
		 ProductResponseRest response = new ProductResponseRest();
				
		//Handling errors
			try {
					
				List<Product> product = (List<Product>) productDao.findAll();
				response.getProductResponse().setProduct(product); //Setter la lista de todas los products
				response.setMetadata("Respuesta exitosa", "00", "CORRECT"); //llenamos el metadata
					
			} catch(Exception e) {
					
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Return response
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	//Method show product by id
	@Override
	@Transactional() //Declare the method as "transactional method"
	public ResponseEntity<ProductResponseRest> searchById(Integer id) {
		
		//Instantiate object
		ProductResponseRest response = new ProductResponseRest();
		List<Product> list = new ArrayList<>();
						
			//Handling errors
			try {
				
				 Optional<Product> product = productDao.findById(id);
				 
			//if the object exists
			if(product.isPresent()) 
			{
				list.add(product.get());
				response.getProductResponse().setProduct(list);
				response.setMetadata("Respuesta exitosa", "00", "CORRECT");

			}
			//Otherwise
			else
			{
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.NOT_FOUND);	
			}
						
							
			} catch(Exception e) {
							
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
						
			//Return response
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	//Method show save product
	@Override
	@Transactional() //Declare the method as "transactional method"
	public ResponseEntity<ProductResponseRest> save(Product product) {
		
		//Instantiate object
		ProductResponseRest response = new ProductResponseRest();
		List<Product> list = new ArrayList<>();
						
			//Handling errors
			try {
						
				 Product productSaved = productDao.save(product);
						
			//if there is response
			if(productSaved != null)
			{
				// We save
				list.add(productSaved);
				response.getProductResponse().setProduct(list);
				response.setMetadata("Respuesta exitosa", "00", "CORRECT");
			}
			//Otherwise
			else
			{
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
						
							
			} catch(Exception e) {
							
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
						
			//Return response
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	//Update product method
	@Override
	@Transactional() //Declare the method as "transactional method"
	public ResponseEntity<ProductResponseRest> update(Product product, Integer id) {
		
		//Instantiate object
		ProductResponseRest response = new ProductResponseRest();
		List<Product> list = new ArrayList<>();
						
			//Handling errors
			try {
						
				// Update with the id		
				Optional<Product> productSearch = productDao.findById(id);
				
				//If the id is found, update
				if(productSearch.isPresent()) 
				{
					productSearch.get().setNameProduct(product.getNameProduct());
					productSearch.get().setCategoryProduct(product.getCategoryProduct());
					productSearch.get().setPriceProduct(product.getPriceProduct());
					
					//Update in the DB
					Product productToUpdate = productDao.save(productSearch.get());
					
					//If find the id
					if(productToUpdate != null)
					{
						list.add(productToUpdate);
						response.getProductResponse().setProduct(list);
						response.setMetadata("Respuesta exitosa", "00", "CORRECT");
					}
					// If it finds the id
					else
					{
						response.setMetadata("Respuesta fallida", "-1", "ERROR");
						return new ResponseEntity<ProductResponseRest>(response, HttpStatus.BAD_REQUEST);
					}
				}
				else
				{
					response.setMetadata("Respuesta fallida", "-1", "ERROR");
					return new ResponseEntity<ProductResponseRest>(response, HttpStatus.NOT_FOUND);
				}		
				
							
			} catch(Exception e) {
							
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
						
			//Return response
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<ProductResponseRest> searchById(Product product, Integer id) {
		
		//Instantiate object
		  ProductResponseRest response = new ProductResponseRest();
		  List<Product> list = new ArrayList<>();
		  
		  	//Handling errors
			try {
				
				// Update with the id	
				Optional<Product> productSearch = productDao.findById(id);
				
				//If the id is found, update
				if(productSearch.isPresent()) 
				{
					// Update product status to Inactive
					product.getStatusProduct();
					productSearch.get().setStatusProduct(String.valueOf("Inactive"));
		
					//Update in the DB
					Product productToUpdate = productDao.save(productSearch.get());
					
					//If find the id
					if(productToUpdate != null)
					{
						list.add(productToUpdate);
						response.getProductResponse().setProduct(list);
						response.setMetadata("Respuesta exitosa", "00", "CORRECT");
					}
					//Otherwise
					else
					{
						response.setMetadata("Respuesta fallida", "-1", "ERROR");
						return new ResponseEntity<ProductResponseRest>(response, HttpStatus.BAD_REQUEST);
					}
				}
				else
				{
					response.setMetadata("Respuesta fallida", "-1", "ERROR");
					return new ResponseEntity<ProductResponseRest>(response, HttpStatus.NOT_FOUND);
				}			
					
			} catch(Exception e) {
					
				//In case of error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Return response
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}

}
