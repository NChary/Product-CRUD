package com.org.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.product.exceptions.ProductNotFoundException;
import com.org.product.model.ApiResponse;
import com.org.product.model.Product;
import com.org.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping("/greet")  // endpoint
	public String greet() {
		return "Welcome to RESTful API Product service";
	}
	
	//Step1: save data
	@PostMapping("/product")
	public String saveProduct(@Valid @RequestBody Product product) {
		return productService.saveProductData(product);
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return productService.fetchAllProducts();
	}
	
	@PutMapping("/product")
	public String updateProductDetails(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/product")
	public String deleteProduct(@RequestBody Product product) {
		return productService.deleteProduct(product);
	}
	
	@DeleteMapping("/product/{pid}")
	public String deleteProductById(@PathVariable Integer pid) {
		return productService.deleteProductById(pid);
	}
	
	@GetMapping("/product/{productName}")
	public ApiResponse findProductByName(@Valid @PathVariable String productName){
		ApiResponse apiResponse = new ApiResponse();
		
		//try {
			apiResponse.setStatusCode(000);
			apiResponse.setStatusMessage("SUCCESS");
			apiResponse.setResult(productService.findProductByName(productName));
			return apiResponse;
//		}catch(Exception exception) {
//			apiResponse.setStatusCode(99);
//			apiResponse.setStatusMessage("FAIL");
//			apiResponse.setResult(exception.getMessage());
//			return apiResponse;
//		}
	}
	
}
