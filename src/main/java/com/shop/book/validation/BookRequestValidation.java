package com.shop.book.validation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shop.book.exception.InvalidBookRequestException;
import com.shop.book.model.Book;
import com.shop.book.util.ApplicationConstant;

import io.micrometer.common.util.StringUtils;

@Component
public class BookRequestValidation {

	public void bookRequestValidation(List<Book> books) {

		if (books == null || books.isEmpty()) {

			throw new InvalidBookRequestException(ApplicationConstant.MISSING_OR_EMPTY_BOOKLIST);
		}

		Optional<Book> result = books.stream()
				.filter(book -> StringUtils.isEmpty(book.getTitle()) || book.getPrice() <= 0 || book.getQuantity() <= 0)
				.findAny();
		if (result.isPresent()) {

			throw new InvalidBookRequestException(ApplicationConstant.INVALID_BOOKLIST);
		}

	}

}
