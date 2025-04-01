package com.org.product.service;

import java.util.List;

import com.org.product.model.Product;

public interface ProductService {

	public String saveProductData(Product product);
	
	public List<Product> fetchAllProducts();

	public String updateProduct(Product product);
	
	public String deleteProduct(Product product);
	
	public String deleteProductById(Integer pid);

	public List<Product> findProductByName(String productName);
}
