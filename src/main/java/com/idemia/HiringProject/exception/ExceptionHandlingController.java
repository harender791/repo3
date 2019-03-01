package com.idemia.HiringProject.exception;



import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        ExceptionResponse response = new ExceptionResponse();
	        response.setErrorCode("Validation Error");
	        response.setErrorMessage("Invalid inputs.");
	        response.setErrors(ValidationUtil.fromBindingErrors(result));
	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	    }
	   
	   @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<ExceptionResponse> invalidInput(DataIntegrityViolationException ex) {
	        //BindingResult result = ex.getBindingResult();
	        ExceptionResponse response = new ExceptionResponse();
	        response.setErrorCode("");
	        response.setErrorMessage("Invalid inputs.");
	        response.setErrors(null);
	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	    }
	   
	   
	  
	   
}
