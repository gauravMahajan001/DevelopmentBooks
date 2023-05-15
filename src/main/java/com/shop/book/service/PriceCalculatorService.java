package com.shop.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;

@Component
public class PriceCalculatorService {

	@Autowired
	private BookCombinaitonPrice bookCombinaitonPrice;

	public BasketPrice calculateBookBasketPrice(List<List<Integer>> possibleBooksCombinationPatternList,
			Map<String, Integer> bookCountBasedOnName, List<Book> booksList) {
		BasketPrice previousCombinationBasketPrice = null;

		for (List<Integer> bookCombinationPattern : possibleBooksCombinationPatternList) {

			Map<String, Integer> copyOfBookBasedOnName = new HashMap<>(bookCountBasedOnName);

			BasketPrice currentCombinationbasketPrice = bookCombinaitonPrice
					.calculateBasketPricePerCombination(bookCombinationPattern, booksList, copyOfBookBasedOnName);

			Integer totalBookSize = bookCombinationPattern.stream().reduce(0, (a, b) -> a + b);

			if (totalBookSize == currentCombinationbasketPrice.getTotalBook()
					&& previousCombinationBasketPrice == null) {
				previousCombinationBasketPrice = currentCombinationbasketPrice;
			}

		}
		return previousCombinationBasketPrice;

	}

}
