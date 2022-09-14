package com.company.sales.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//Entidad mapeada como una tabla en la bd

// Usamos Lombok para la creación de getters y setters
@Data
@Entity
@Table(name="customers")
public class Customer implements Serializable{
	

	//Attributes the Class
	
	private static final long serialVersionUID = 1L;


		//Specify ID and autoincrement
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="CodCustomer")
		private Integer id;
		
		
		//Attribute names equal to those in the database
		@Column(name="NameCustomer")
		private String nameCustomer;
		
		@Column(name="LastNameCustomer")
		private String lastNameCustomer;
		
		@Column(name="CityCustomer")
		private String cityCustomer;

		
}
