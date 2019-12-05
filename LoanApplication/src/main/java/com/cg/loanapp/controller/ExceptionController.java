package com.cg.loanapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.loanapp.exception.CustomerException;
import com.cg.loanapp.exception.LoanException;
import com.cg.loanapp.model.ErrorClass;

@RestControllerAdvice
public class ExceptionController {
	/*
	 * @Autowired ErrorClass error;
	 */
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String> customerException(CustomerException cust){
		
		/*
		 * error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		 * error.setErrorMsg(cust.getMessage());
		 */
		return new ResponseEntity<String>(cust.getMessage(),HttpStatus.OK);
	}
	@ExceptionHandler(LoanException.class)
	public ResponseEntity<String> loanException(LoanException loan){
		
		/*
		 * error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		 * error.setErrorMsg(loan.getMessage());
		 */
		return new ResponseEntity<String>(loan.getMessage(),HttpStatus.OK);
	}	
	@ExceptionHandler(Exception .class)
	public ResponseEntity<String> generalException(Exception e){
		/*
		 * error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		 * error.setErrorMsg(e.getMessage());
		 */
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
	}
	
	
	
}
