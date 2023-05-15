package com.shop.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shop.book.model.Book;
import com.shop.book.util.CreateBook;

class BookMetaDataTest {

	private final BookMetaData bookMetaData = new BookMetaData();

	@Test
	@DisplayName("should count books based on book name")
	void testCountBooksBasedOnBookName() {
		List<Book> books = getBookist();
		int totalBooks = 2;
		String bookName = "Java";

		Map<String, Integer> result = bookMetaData.getBookCountMapBasedOnName(books);

		assertEquals(totalBooks, result.get(bookName));
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
