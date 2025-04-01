package com.org.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	//Define Custom method 
	Optional<List<Product>> findByPname(String productName);
	
}
