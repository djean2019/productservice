package com.gap.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gap.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);
}
