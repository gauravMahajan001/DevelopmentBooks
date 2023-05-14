package com.shop.book.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shop.book.exception.ExceptionResponse;
import com.shop.book.exception.InvalidBookRequestException;
import com.shop.book.util.ApplicationConstant;

class GlobalExceptionHandlerTest {

	private final GlobalExceptionHandler controllerAdvice = new GlobalExceptionHandler();

	@Test
	@DisplayName("should error handling when application throw bad request error InvalidBookRequestException ")
	void testErrorMessageAndHttpStatusWhenApplicationThrowError() {
		InvalidBookRequestException exception = new InvalidBookRequestException(
				ApplicationConstant.MISSING_OR_EMPTY_BOOKLIST);

		ResponseEntity<ExceptionResponse> result = controllerAdvice.handleResourceNotFound(exception);

		assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
		assertEquals(ApplicationConstant.MISSING_OR_EMPTY_BOOKLIST, result.getBody().getErrorMessage());
	}

}
