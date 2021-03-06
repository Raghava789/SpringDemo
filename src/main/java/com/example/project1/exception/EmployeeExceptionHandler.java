package com.example.project1.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.project1.bean.EmployeeErrorResponse;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception) {
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		//error.setTimeStamp(System.currentTimeMillis());
		error.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	
	
	
}
