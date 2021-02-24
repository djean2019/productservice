package com.gap.productservice;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Product")
public class ProductNotFoundException extends RuntimeException {

	
	public ProductNotFoundException(String message) {
		super(String.format("City with Id %s not found", message));
	}
	
	public ProductNotFoundException() {
		 super("No data found");
	}
}
