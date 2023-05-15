package com.shop.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;
import com.shop.book.util.CreateBook;

class BookCombinaitonPriceTest {

	@InjectMocks
	private BookCombinaitonPrice bookCombinaitonPrice;
	@Mock
	private BookMetaData bookMetaData;
	private List<Book> books;
	private Map<String, Integer> bookCountMapBasedOnName;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		books = getBookist();
		bookCountMapBasedOnName = getBookCountMapBasedOnName();
	}

	@Test
	@DisplayName("should calculate basket price per book combination")
	void testcalculateBasketPricePerCombination() {
		Integer[] bookCombination = { 4, 4 };
		List<Integer> book_Combination = Arrays.asList(bookCombination);
		double expectedBooksPrice = 400;
		int totalBooks = 4;

		doReturn(books).when(bookMetaData).getBookListForACombination(totalBooks, books, bookCountMapBasedOnName);
		BasketPrice result = bookCombinaitonPrice.calculateBasketPricePerCombination(book_Combination, books,
				bookCountMapBasedOnName);

		assertEquals(expectedBooksPrice, result.getTotalPrice());
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
