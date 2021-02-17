package com.gap.productservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gap.productservice.ProductNotFoundException;
import com.gap.productservice.model.Product;
import com.gap.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product getProductDetails(String name) {
		Product product = productRepository.findByName(name);
		if(product == null) {
			throw new ProductNotFoundException();
		}
		return product;
	}
	
	
	public ProductDTO getProduct(String name) {
		Optional<Product> result = Optional.of(productRepository.findByName(name));
		if (result.isPresent())
			  return ProductAdapter.getProductDTO(result.get());
		else
//			return null;
			throw new ProductNotFoundException();

	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
}
