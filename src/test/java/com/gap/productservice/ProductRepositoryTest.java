package com.gap.productservice;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gap.productservice.model.Product;
import com.gap.productservice.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
//	@Autowired
//	private TestEntityManager entityManager;

	@Test
	public void getProductTest() {
//		Product SavedProduct = entityManager.persistAndFlush(new Product("iPhone", 200.00));
		Product product = productRepository.findByName("iPhone");

		assertThat(product.getName()).isEqualTo("iPhone");
		assertThat(product.getPrice()).isEqualTo(200.00);
	}

}
