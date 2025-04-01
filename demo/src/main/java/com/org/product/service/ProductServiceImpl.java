package com.org.product.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.product.exceptions.ProductNotFoundException;
import com.org.product.model.Product;
import com.org.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public String saveProductData(Product product) {
		productRepository.save(product);
		return "Product details saved successfully";
	}


	@Override
	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}


	@Override
	public String updateProduct(Product product) {
		productRepository.save(product);
		return "Product details updated successfully";
	}


	@Override
	public String deleteProduct(Product product) {
		productRepository.delete(product);
		return "Product deleted successfully";
	}


	@Override
	public String deleteProductById(Integer pid) {
		productRepository.deleteById(pid);
		return "Product deleted successfully";
	}


	@Override
	public List<Product> findProductByName(String productName) {
		
		List<Product> productList =null;
		
		Optional<List<Product>> optLstProduct = productRepository.findByPname(productName);
		
		if(!optLstProduct.isEmpty()) {
			productList = optLstProduct.get();
			if(!productList.isEmpty()) {
				return productList;
			}else {
				throw new ProductNotFoundException("No results for "+productName);
			}
		}
		return productList;

	}
	
}
