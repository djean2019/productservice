package com.gap.productservice.service;

import com.gap.productservice.model.Product;

public class ProductAdapter {
//	public static Product getProduct(ProductDTO productDTO) {
//		Product product = new Product(
//				productDTO.getName(),
//				productDTO.getPrice()
//				);		
//		return product;				
//	}
//	
//	public static ProductDTO getProductDTO(Product product) {
//		ProductDTO productDTO = new ProductDTO(
//				product.getName(),
//				product.getPrice()
//				);		
//		return productDTO;				
//	}
	public static Product getProguct(ProductDTO productDTO) {
		return new Product(productDTO.getName(), productDTO.getPrice());
	}
	public static ProductDTO getProductDTO(Product product) {
		return new ProductDTO(product.getName(), product.getPrice());
	}
}

// No converter found capable of converting from type [com.gap.productservice.model.Product] 
// to type [com.gap.productservice.service.ProductDTO]