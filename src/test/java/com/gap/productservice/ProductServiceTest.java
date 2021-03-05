package com.gap.productservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.gap.productservice.model.Product;
import com.gap.productservice.repository.ProductRepository;
import com.gap.productservice.service.ProductDTO;
import com.gap.productservice.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;
	
	private ProductService productService;
	
	@Before
	public void setUp() {
		productService = new ProductService(productRepository);
	}
	
	@Test
	public void getProductTest() throws Exception {

//		given(productService.getProductDetails(anyString())).willReturn(new Product("iPhone",200.00));

//		given(productService.getProductDetails(anyString())).willReturn(new Product(1,"iPhone",200.00,"ssavvs"));	
//		Product product = productService.getProductDetails("iPhone");
//
//		assertThat(product.getName()).isEqualTo("iPhone");
//		assertThat(product.getPrice()).isEqualTo(200.00);
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void productNotFound() throws Exception{
		given(productService.getProductDetails("iPhone")).willReturn(null);
		
		productService.getProductDetails("iPhone");
	}
}
