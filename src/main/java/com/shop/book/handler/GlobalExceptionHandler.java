package com.shop.book.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shop.book.exception.ExceptionResponse;
import com.shop.book.exception.InvalidBookRequestException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidBookRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionResponse> handleResourceNotFound(final InvalidBookRequestException exception) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
