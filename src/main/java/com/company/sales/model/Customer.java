package com.company.sales.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//Entity mapped as a table in the database

//We use Lombok for the creation of getters and setters
@Data
@Entity
@Table(name="customers")
public class Customer implements Serializable{
	

	//Attributes the Class
	
	private static final long serialVersionUID = 1L;

		//Specify ID and autoincrement
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="cod_customer")
		private Integer id;
		
		
		//Attribute names equal to those in the database
		@Column(name="name_customer")
		private String nameCustomer;
		@Column(name="last_name_customer")
		private String lastNameCustomer;
		@Column(name="city_customer")
		private String cityCustomer;

		
}
