package com.gap.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gap.productservice.ProductNotFoundException;
import com.gap.productservice.model.Product;
import com.gap.productservice.service.ProductDTO;
import com.gap.productservice.service.ProductService;

@RestController
public class ProductController {

	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products/{name}")
	public ResponseEntity<?> getProduct(@PathVariable String name) {
		ProductDTO product = productService.getProduct(name);
		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}


	@GetMapping("/products/details/{name}")
	public ResponseEntity<?> getProductDetails(@PathVariable String name) {
		Product product = productService.getProductDetails(name);
//		List<String> list = new ArrayList<String>();
//		list.add(product.getName());
//		list.add(""+product.getPrice());
//		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@PostMapping(value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		productService.addProduct(product);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void productNotFoundHandler(ProductNotFoundException e) {
		
	}
}