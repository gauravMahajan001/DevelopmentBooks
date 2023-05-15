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

class ShoppingBasketTest {

	@InjectMocks
	private ShoppingBasket shoppingBasket;

	@Mock
	private BookMetaData bookMetaData;

	@Mock
	private PriceCalculatorService orderPrice;

	@Mock
	private BookCombinationAlgorithm algorithm;
	
	private List<List<Integer>> bookCombinations;
	private BasketPrice basketPrice;
	private List<Book> books;
	private Map<String, Integer> bookCountMapBasedOnName; 
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		bookCombinations = getBookCombinations();
		basketPrice = getBasketPrice();
		books = getBookist();
		bookCountMapBasedOnName = getBookCountMapBasedOnName();
	}

	@Test
	@DisplayName("calculate basket price")
	void calculateBasketPrice() {
		doReturn(2).when(bookMetaData).getBooksQantity(books);
		doReturn(bookCountMapBasedOnName).when(bookMetaData).getBookCountMapBasedOnName(books);
		doReturn(bookCombinations).when(bookMetaData).createBookCombinationBasedUponTotalBooks(books.size());
		doReturn(basketPrice).when(orderPrice).calculateBookBasketPrice(bookCombinations, bookCountMapBasedOnName,
				books);
		BasketPrice result = shoppingBasket.calculateBasketPrice(books);

		assertEquals(100, result.getTotalPrice());
	}

	private List<Book> getBookist() {
		List<Book> books = new ArrayList<>();
		books.add(CreateBook.create("Java", 50.0, 1));
		books.add(CreateBook.create("Code", 50.0, 1));

		return books;
	}

	private Map<String, Integer> getBookCountMapBasedOnName() {
		Map<String, Integer> bookCountMapBasedOnName = new HashMap<>();
		bookCountMapBasedOnName.put("Java", 1);
		bookCountMapBasedOnName.put("Code", 1);

		return bookCountMapBasedOnName;
	}

	private List<List<Integer>> getBookCombinations() {
		List<Integer> bookCombination1List = Arrays.asList(1, 1);
		List<Integer> bookCombination2List = Arrays.asList(2);
		List<List<Integer>> bookCombinations = new ArrayList<>();
		bookCombinations.add(bookCombination1List);
		bookCombinations.add(bookCombination2List);

		return bookCombinations;
	}

	private BasketPrice getBasketPrice() {
		BasketPrice basketPrice = new BasketPrice();
		basketPrice.setTotalPrice(100);
		basketPrice.setTotalBook(2);
		return basketPrice;
	}

}
