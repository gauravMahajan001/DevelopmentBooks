package com.shop.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;
import com.shop.book.model.DiscountDto;

@Component
public class BookCombinaitonPrice {

	@Autowired
	private BookMetaData bookMetaData;
	@Autowired
	private Discount discount;

	public BasketPrice calculateBasketPricePerCombination(List<Integer> bookCombinations, List<Book> booksList,
			Map<String, Integer> bookCountsBasedOnName) {
		BasketPrice result = new BasketPrice();
		bookCombinations.forEach(combination -> {

			List<Book> bookListPerCombination = bookMetaData.getBookListForACombination(combination, booksList,
					bookCountsBasedOnName);

			if (combination == bookListPerCombination.size()) {

				double booksPrice = calculatePricePerBookList(bookListPerCombination);
				DiscountDto discountDto= discount.getDiscountOnCombination(booksPrice, bookListPerCombination);
				result.setTotalPrice(discountDto.getDiscountedBookPrice());
			}
		});
		return result;
	}

	private double calculatePricePerBookList(List<Book> bookListPerCombination) {

		return bookListPerCombination.stream().map(Book::getPrice).reduce(0.0, (a, b) -> a + b);
	}

}
