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
import com.company.sales.model.Customer;
import com.company.sales.model.Product;
import com.company.sales.response.CustomerResponseRest;
import com.company.sales.response.ProductResponseRest;

//Indicar que es una clase de servicio
@Service
public class ProductServiceImp implements iProductService{

	@Autowired  //Injectar este objeto para usarlo en spring
	private iProductDao productDao;
	
	
	//Método mostrar todos los customers
	@Override
	@Transactional() //Declarar el método como "método trasancional"

	public ResponseEntity<ProductResponseRest> search() {
		
		//Instanciar objeto
		 ProductResponseRest response = new ProductResponseRest();
				
			//Manejar errores
			try {
					
				List<Product> product = (List<Product>) productDao.findAll();
				response.getProductResponse().setProduct(product); //Setter la lista de todas los products
				response.setMetadata("Respuesta exitosa", "00", "CORRECT"); //llenamos el metadata
					
			} catch(Exception e) {
					
				//En caso de error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Retornar respuesta
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	//Método mostrar product por id
	@Override
	@Transactional() //Declarar el método como "método trasancional"
	public ResponseEntity<ProductResponseRest> searchById(Integer id) {
		
		//Instanciar objeto
		ProductResponseRest response = new ProductResponseRest();
		List<Product> list = new ArrayList<>();
						
			//Manejar errores
			try {
				
				 Optional<Product> product = productDao.findById(id);
				 
			//Si el objeto existe
			if(product.isPresent()) 
			{
				list.add(product.get());
				response.getProductResponse().setProduct(list);
				response.setMetadata("Respuesta exitosa", "00", "CORRECT");

			}
			//En caso contrario
			else
			{
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.NOT_FOUND);	
			}
						
							
			} catch(Exception e) {
							
				//En caso de error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
						
			//Retornar respuesta
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	//Método mostrar guardar product
	@Override
	@Transactional() //Declarar el método como "método trasancional"
	public ResponseEntity<ProductResponseRest> save(Product product) {
		
		//Instanciar objeto
		ProductResponseRest response = new ProductResponseRest();
		List<Product> list = new ArrayList<>();
						
		   //Manejar errores
			try {
						
				 Product productSaved = productDao.save(product);
						
			//Si hay respuesta
			if(productSaved != null)
			{
				//Guardamos
				list.add(productSaved);
				response.getProductResponse().setProduct(list);
				response.setMetadata("Respuesta exitosa", "00", "CORRECT");
			}
			//En caso contrario
			else
			{
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
						
							
			} catch(Exception e) {
							
			//En caso de error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
						
			//Retornar respuesta
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	//Método actualizar product
	@Override
	@Transactional() //Declarar el método como "método trasancional"
	public ResponseEntity<ProductResponseRest> update(Product product, Integer id) {
		
		//Instanciar objeto
		ProductResponseRest response = new ProductResponseRest();
		List<Product> list = new ArrayList<>();
						
		   //Manejar errores
			try {
						
				//Actualizar con el id 		
				Optional<Product> productSearch = productDao.findById(id);
				
				//Si el id es encontrado, actualiza
				if(productSearch.isPresent()) 
				{
					productSearch.get().setNameProduct(product.getNameProduct());
					productSearch.get().setCategoryProduct(product.getCategoryProduct());
					productSearch.get().setPriceProduct(product.getPriceProduct());
					
					//Actualizar en la BD
					Product productToUpdate = productDao.save(productSearch.get());
					
					//Si encuentra el id
					if(productToUpdate != null)
					{
						list.add(productToUpdate);
						response.getProductResponse().setProduct(list);
						response.setMetadata("Respuesta exitosa", "00", "CORRECT");
					}
					//En caso contrario
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
							
			//En caso de error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
						
			//Retornar respuesta
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<ProductResponseRest> searchById(Product product, Integer id) {
		
		//Instanciar objeto
		  ProductResponseRest response = new ProductResponseRest();
		  List<Product> list = new ArrayList<>();
		  
			//Manejar errores
			try {
				
				//Actualizar con el id 		
				Optional<Product> productSearch = productDao.findById(id);
				
				//Si el id es encontrado, actualiza
				if(productSearch.isPresent()) 
				{
					//Actualizar el estado del product a Inactive
					product.getStatusProduct();
					productSearch.get().setStatusProduct(String.valueOf("Inactive"));
		
					//Actualizar en la BD
					Product productToUpdate = productDao.save(productSearch.get());
					
					//Si encuentra el id
					if(productToUpdate != null)
					{
						list.add(productToUpdate);
						response.getProductResponse().setProduct(list);
						response.setMetadata("Respuesta exitosa", "00", "CORRECT");
					}
					//En caso contrario
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
					
				//En caso de error
				response.setMetadata("Respuesta fallida", "-1", "ERROR");
				e.getStackTrace();
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
			}
				
			//Retornar respuesta
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.OK);
	}

}
