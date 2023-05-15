package com.shop.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shop.book.model.Book;
import com.shop.book.model.DiscountDto;
import com.shop.book.util.CreateBook;

class DiscountTest {

	private final Discount discount = new Discount();

	@Test
	@DisplayName("should calculate discount on book list")
	void testCalculateDiscountOnBookList() {
		double booksPrice = 200;
		double expectedDiscountPrice = 160;
		DiscountDto discountDto = discount.getDiscountOnCombination(booksPrice, getBookist());

		assertEquals(expectedDiscountPrice, discountDto.getDiscountedBookPrice());
	}

	private List<Book> getBookist() {
		List<Book> books = new ArrayList<>();

		books.add(CreateBook.create("Java", 50, 2));
		books.add(CreateBook.create("Code", 50, 2));
		books.add(CreateBook.create("Junit", 50, 2));
		books.add(CreateBook.create("Test", 50, 2));

		return books;
	}

}
