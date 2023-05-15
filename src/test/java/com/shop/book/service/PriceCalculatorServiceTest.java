package com.shop.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

class PriceCalculatorServiceTest {

	@InjectMocks
	private PriceCalculatorService priceCalculatorService;
	@Mock
	private BookCombinaitonPrice bookCombinaitonPrice;
	private List<Book> books;
	private Map<String, Integer> bookCountMapBasedOnName;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		books = getBookist();
		bookCountMapBasedOnName = getBookCountMapBasedOnName();
	}

	@Test
	@DisplayName("should calculate basket price based on book combinations")
	void testCalculateBasketPriceBasedOnBookCombination() {
		Integer[] bookCombination = { 4, 4 };
		List<Integer> book_Combination = Arrays.asList(bookCombination);
		List<List<Integer>> booksCombinationPatternList = new ArrayList<>();
		booksCombinationPatternList.add(book_Combination);
		BasketPrice basketPrice = new BasketPrice();
		basketPrice.setTotalPrice(320);
		basketPrice.setTotalBook(8);

		doReturn(basketPrice).when(bookCombinaitonPrice).calculateBasketPricePerCombination(book_Combination, books,
				bookCountMapBasedOnName);

		BasketPrice result = priceCalculatorService.calculateBookBasketPrice(booksCombinationPatternList,
				bookCountMapBasedOnName, books);

		assertNotNull(result);
	}

	@Test
	@DisplayName("should calculate minimum basket price based on book combinations")
	void testCalculateMinimumBasketPriceBasedOnBookCombination() {
		Integer[] bookCombination = { 4, 4 };
		List<Integer> book_Combination = Arrays.asList(bookCombination);
		Integer[] bookCombination1 = { 1, 1, 1, 1, 1, 1, 1, 1 };
		List<Integer> book_Combination1 = Arrays.asList(bookCombination1);
		List<List<Integer>> booksCombinationPatternList = new ArrayList<>();
		booksCombinationPatternList.add(book_Combination);
		booksCombinationPatternList.add(book_Combination1);
		double expectedbooksPrice = 320;
		BasketPrice basketPrice = new BasketPrice();
		basketPrice.setTotalPrice(320);
		basketPrice.setTotalBook(8);
		BasketPrice basketPrice1 = new BasketPrice();
		basketPrice1.setTotalPrice(400);
		basketPrice1.setTotalBook(8);

		doReturn(basketPrice).when(bookCombinaitonPrice).calculateBasketPricePerCombination(book_Combination, books,
				bookCountMapBasedOnName);
		doReturn(basketPrice1).when(bookCombinaitonPrice).calculateBasketPricePerCombination(book_Combination1, books,
				bookCountMapBasedOnName);

		BasketPrice result = priceCalculatorService.calculateBookBasketPrice(booksCombinationPatternList,
				bookCountMapBasedOnName, books);

		assertEquals(expectedbooksPrice, result.getTotalPrice());
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
