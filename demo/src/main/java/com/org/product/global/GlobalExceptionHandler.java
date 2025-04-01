package com.org.product.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.product.exceptions.ProductNotFoundException;
import com.org.product.model.ApiResponse;


//Step1: add this annotation to a class to convert into global exception handler 
// 1 class per project
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
	

	//Step2: Add below annotation to handle exception across the project
	@ExceptionHandler(ProductNotFoundException.class)
	public ApiResponse handleProductNotFoundException(ProductNotFoundException productNotFoundException){
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatusCode(99);
		apiResponse.setStatusMessage("FAIL");
		apiResponse.setResult(productNotFoundException.getMessage());
		return apiResponse;
	}
	
	//Default to be added to this class
	@ExceptionHandler(Exception.class)
	public ApiResponse handleExcpetion(Exception exception) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatusCode(99);
		apiResponse.setStatusMessage("FAIL");
		apiResponse.setResult("Server is down and please try again after some time");
		return apiResponse;
	}
	
}
