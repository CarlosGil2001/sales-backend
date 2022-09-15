package com.company.sales.model;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//Entity mapped as a table in the database

//We use Lombok for the creation of getters and setters
@Data
@Entity
@Table(name="orders")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//Specify ID and autoincrement
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_order")
	private Integer id;
			
			
	//Attribute names equal to those in the database
	@Column(name="date_order")
	private Timestamp dateOrder;
	@Column(name="status_order")
	private String statusOrder="Active";
	@Column(name="taxes_order")
	private float taxesOrder=(float) 27.23;
	@Column(name="sub_total")
	private String subTotal;
	@Column(name="total_order")
	private String totalOrder=subTotal + taxesOrder;
	
	//Many to One (Customers and Order)
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"}) //Ignore properties
	private Customer customer;
}
