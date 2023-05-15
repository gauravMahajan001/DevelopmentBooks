package com.shop.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shop.book.model.Book;
import com.shop.book.util.CreateBook;

class BookMetaDataTest {

	private final BookMetaData bookMetaData = new BookMetaData();
	private List<Book> books;
	private Map<String, Integer> bookCountMapBasedOnName;

	@BeforeEach
	public void setup() {
		books = getBookist();
		bookCountMapBasedOnName = getBookCountMapBasedOnName();
	}

	@Test
	@DisplayName("should count books based on book name")
	void testCountBooksBasedOnBookName() {
		int totalBooks = 2;
		String bookName = "Java";
		Map<String, Integer> result = bookMetaData.getBookCountMapBasedOnName(books);

		assertEquals(totalBooks, result.get(bookName));
	}

	@Test
	@DisplayName("should retrieve book and reduce available count")
	void testBookAndReduceAvailableCount() {
		int reduceCount = 1;
		String bookName = "Java";
		int bookIndex = 0;
		Book result = bookMetaData.getBookAndReduceAvailableCount(bookIndex, books, bookCountMapBasedOnName);

		assertEquals(bookName, result.getTitle());
		assertEquals(reduceCount, bookCountMapBasedOnName.get(bookName));
	}

	private List<Book> getBookist() {
		List<Book> books = new ArrayList<>();
		books.add(CreateBook.create("Java", 50, 2));
		books.add(CreateBook.create("Code", 50, 2));
		books.add(CreateBook.create("Junit", 50, 2));
		books.add(CreateBook.create("Test", 50, 2));

		return books;
	}

	private Map<String, Integer> getBookCountMapBasedOnName() {
		Map<String, Integer> bookCountMapBasedOnName = new HashMap<>();
		bookCountMapBasedOnName.put("Java", 2);
		bookCountMapBasedOnName.put("Code", 2);
		bookCountMapBasedOnName.put("Junit", 2);
		bookCountMapBasedOnName.put("Test", 2);

		return bookCountMapBasedOnName;
	}

}
