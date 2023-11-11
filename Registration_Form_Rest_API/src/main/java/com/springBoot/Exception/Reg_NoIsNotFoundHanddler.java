package com.springBoot.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Reg_NoIsNotFoundHanddler {
	
	@ExceptionHandler(Reg_NoIsNotFound.class)
	public ResponseEntity<ErrorMessage> Reg_NoIsNotFoundHanddlerException(Reg_NoIsNotFound rnfe){
		
		
		//return new ResponseEntity<String>(rnfe.getMessage(),HttpStatus.NOT_FOUND);
		
		// Its Optional way 
		return new ResponseEntity<ErrorMessage>( new ErrorMessage(
														rnfe.getMessage(),
														new Date().toString(),
														"Registration Form"),
												HttpStatus.NOT_FOUND);

	}

}
