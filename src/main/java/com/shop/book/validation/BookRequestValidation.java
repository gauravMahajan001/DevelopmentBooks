package com.shop.book.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shop.book.exception.InvalidBookRequestException;
import com.shop.book.model.Book;
import com.shop.book.util.ApplicationConstant;

@Component
public class BookRequestValidation {
	
	public void bookRequestValidation(List<Book> books) {

		if (books == null) {

			throw new InvalidBookRequestException(ApplicationConstant.MISSING_BOOKLIST);
		}
		
	}
	
}
