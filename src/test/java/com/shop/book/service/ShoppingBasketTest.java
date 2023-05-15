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
import org.mockito.Spy;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;

class ShoppingBasketTest {

	@InjectMocks
	private ShoppingBasket shoppingBasket;

	@Mock
	private BookMetaData bookMetaData;

	@Mock
	private PriceCalculatorService orderPrice;

	@Mock
	private BookCombinationAlgorithm algorithm;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	@DisplayName("calculate basket price")
	void calculateBasketPrice() {
		
		List<Integer> bookCombination1List = Arrays.asList(1, 1);
		List<Integer> bookCombination2List = Arrays.asList(2);
		List<List<Integer>> bookCombinations = new ArrayList<>();
		bookCombinations.add(bookCombination1List);
		bookCombinations.add(bookCombination2List);
        
		int totalBooks =2;
		double totalBookPrice = 100;
		BasketPrice basketPrice = new BasketPrice();
		basketPrice.setTotalPrice(totalBookPrice);
		basketPrice.setTotalBook(totalBooks);

		List<Book> books = getBookist();
		Map<String, Integer> bookCountMapBasedOnName = getBookCountMapBasedOnName();
		doReturn(totalBooks).when(bookMetaData).getBooksQantity(books);
		doReturn(bookCountMapBasedOnName).when(bookMetaData).getBookCountMapBasedOnName(books);
        doReturn(bookCombinations).when(bookMetaData).createBookCombinationBasedUponTotalBooks(books.size());
		doReturn(basketPrice).when(orderPrice).calculateBookBasketPrice(bookCombinations, bookCountMapBasedOnName,
				books);
		BasketPrice result = shoppingBasket.calculateBasketPrice(books);

		assertEquals(totalBookPrice, result.getTotalPrice());
	}
	
	private Book createBook(String title, double price, int quantity) {
		return new Book(title, price, quantity);
	}

	private List<Book> getBookist() {
		List<Book> books = new ArrayList<>();
		Book book1 = createBook("Java", 50.0, 1);
		Book book2 = createBook("Code", 50.0, 1);
		books.add(book1);
		books.add(book2);

		return books;
	}

	private Map<String, Integer> getBookCountMapBasedOnName() {
		Map<String, Integer> bookCountMapBasedOnName = new HashMap<>();
		bookCountMapBasedOnName.put("Java", 1);
		bookCountMapBasedOnName.put("Code", 1);

		return bookCountMapBasedOnName;
	}

}
