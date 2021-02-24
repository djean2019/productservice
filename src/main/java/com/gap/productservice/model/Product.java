package com.gap.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}")
//String phoneNumber;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productNumber;
	
	@NotEmpty(message = "Product name must not be empty.")
	private String name;
	
	@NotNull(message = "You should provide a value for the price.")
	@Digits(integer=6, fraction=2)
	@Column(name= "price", nullable =false)
	private double price;
	
	@Size(min=2, max=240)
	private String description;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
}
