package com.shop.book.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shop.book.exception.InvalidBookRequestException;
import com.shop.book.model.Book;
import com.shop.book.util.ApplicationConstant;

class BookRequestValidationTest {

	private final BookRequestValidation validation = new BookRequestValidation();

	@Test
	@DisplayName("throw exception when user send missing book list")
	void testExceptionWhenBookListNull() {
		List<Book> books = null;
		Exception exception = assertThrows(InvalidBookRequestException.class,
				() -> validation.bookRequestValidation(books));

		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(ApplicationConstant.MISSING_OR_EMPTY_BOOKLIST));
	}

	@Test
	@DisplayName("throw exception when user send empty book list")
	void testExceptionWhenBookListEmpty() {
		List<Book> books = new ArrayList<>();

		Exception exception = assertThrows(InvalidBookRequestException.class,
				() -> validation.bookRequestValidation(books));

		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(ApplicationConstant.MISSING_OR_EMPTY_BOOKLIST));
	}

}
