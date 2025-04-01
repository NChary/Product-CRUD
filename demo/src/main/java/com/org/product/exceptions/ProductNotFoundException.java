package com.org.product.exceptions;
//Step1: extends RuntimeException
public class ProductNotFoundException extends RuntimeException{

	//Step2: Define PC - pass message
	public ProductNotFoundException(String message) {
		super(message);
	}
	
}
