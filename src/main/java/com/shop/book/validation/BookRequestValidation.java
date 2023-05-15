package com.shop.book.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
		Set<String> uniqueBookNameList = books.stream().map(Book::getTitle).collect(Collectors.toSet());

		if (result.isPresent() || uniqueBookNameList.size() != books.size()) {

			throw new InvalidBookRequestException(ApplicationConstant.INVALID_BOOKLIST);
		}

	}

}
