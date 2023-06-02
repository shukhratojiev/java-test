package com.example.demo.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> handleItemAlreadyExistsException(ItemAlreadyExistsException ex, WebRequest request){
		
		ErrorMessage em = new ErrorMessage();
		em.setMessage(ex.getMessage());

        return new ResponseEntity<>(em, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException ex, WebRequest request){
		
		ErrorMessage em = new ErrorMessage();
		em.setMessage("Required item by id not found");

        return new ResponseEntity<>(em, HttpStatus.NOT_FOUND);
	}
}
