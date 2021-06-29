package com.gap.productservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.gap.productservice.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductserviceIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getProductDetailstest() throws Exception {
		// arrange
		
		// act
		ResponseEntity<Product> response = restTemplate.getForEntity("/products/iPhone", Product.class);
		
		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getName()).isEqualTo("iPhone");
		assertThat(response.getBody().getPrice()).isEqualTo(200.00);
	}

}
