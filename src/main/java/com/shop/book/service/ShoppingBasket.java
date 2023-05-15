package com.shop.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;

@Service
public class ShoppingBasket {

	@Autowired
	private BookMetaData bookMetaData;

	@Autowired
	private PriceCalculatorService orderPrice;

	public BasketPrice calculateBasketPrice(List<Book> booksList) {

		int totalBooks = bookMetaData.getBooksQantity(booksList);

		List<List<Integer>> bookCombinations = bookMetaData.createBookCombinationBasedUponTotalBooks(totalBooks);

		Map<String, Integer> bookCountMapBasedOnName = bookMetaData.getBookCountMapBasedOnName(booksList);

		return orderPrice.calculateBookBasketPrice(bookCombinations, bookCountMapBasedOnName, booksList);

	}

}
