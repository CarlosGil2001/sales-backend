package com.company.sales.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.sales.dao.iProductDao;
import com.company.sales.model.Product;
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

}
