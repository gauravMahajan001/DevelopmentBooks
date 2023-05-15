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

import com.shop.book.model.Book;
import com.shop.book.util.CreateBook;

class BookMetaDataTest {

	@InjectMocks
	private BookMetaData bookMetaData;
	@Mock
	private BookCombinationAlgorithm algorithm;
	private List<Book> books;
	private Map<String, Integer> bookCountMapBasedOnName;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
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

	@Test
	@DisplayName("should retrieve book list based on combination")
	void testBookListFromACombination() {
		int totalBookInABookCombination = 4;
		List<Book> result = bookMetaData.getBookListForACombination(totalBookInABookCombination, books,
				bookCountMapBasedOnName);

		assertEquals(totalBookInABookCombination, result.size());
	}
	
	@Test
	@DisplayName("should get books name")
	void testBooksName() {
		List<String> result = bookMetaData.getBooksName(books);

		assertEquals(getBookist().size(), result.size());
	}
	
	@Test
	@DisplayName("should calculate book combination based on books")
	void testBookCombination() {
		int[] rulesBasedOnDiscount = { 1, 2, 3, 4, 5 };
		
		List<Integer> bookCombination1List = Arrays.asList(1, 1);
		List<Integer> bookCombination2List = Arrays.asList(2);
		List<List<Integer>> bookCombinations = new ArrayList<>();
		bookCombinations.add(bookCombination1List);
		bookCombinations.add(bookCombination2List);
		int totalBooks = 2;
		
		doReturn(bookCombinations).when(algorithm).createBookCombinationBasedUponTotalBooks(rulesBasedOnDiscount, totalBooks);
		List<List<Integer>> result = bookMetaData.createBookCombinationBasedUponTotalBooks(totalBooks);
		
		assertEquals(bookCombinations, result);
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
