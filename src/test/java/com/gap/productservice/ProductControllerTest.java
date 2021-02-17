package com.gap.productservice;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

import com.gap.productservice.controller.ProductController;
import com.gap.productservice.model.Product;
import com.gap.productservice.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	@Test
	public void getProductTest() throws Exception {

		given(productService.getProductDetails(anyString())).willReturn(new Product("iPhone",200.00));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/products/iPhone"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("name").value("iPhone"))
		.andExpect(jsonPath("price").value(200.00));
	}
	
	@Test
	public void productNotFound() throws Exception{
		given(productService.getProductDetails(anyString())).willThrow(new ProductNotFoundException());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/products/iPhone"))
		.andExpect(status().isNotFound());
	}

}
