package com.gap.productservice;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Product")
public class ProductNotFoundException extends RuntimeException {


	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(String.format(message+ "is not found in product list..."));
	}
}
