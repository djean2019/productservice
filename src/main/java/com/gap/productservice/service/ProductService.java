package com.gap.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
			throw new ProductNotFoundException(name);
		}
		return product;
	}
	@Cacheable(value="product-ca")
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	
	@Cacheable(value="product-cache", key="'ProductCache'+#name")
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
	
	public Product updateProduct(Product p) {
		Product product = productRepository.findById(p.getProductNumber()).orElse(null);
		if(product != null) {
			try {
				return productRepository.save(p);
			}
			catch(ProductNotFoundException e) {
				return null;
			}
		} else {
			throw new ProductNotFoundException();
		}
	}

//	public void delete(int productNumber) {
//		Product product = productRepository.findById(productNumber).orElse(null);
//		if(product != null) {
//			try {
//				 productRepository.deleteById(productNumber);;
//			}
//			catch(ProductNotFoundException e) {
//				return;
//			}
//		} else {
//			throw new ProductNotFoundException();
//		}
//	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public void delete(int productNumber) {
		Product product = productRepository.findById(productNumber).orElse(null);
		if(product != null)
			productRepository.deleteById(productNumber);
		else
			System.out.println("Product not found...");
	}
}
