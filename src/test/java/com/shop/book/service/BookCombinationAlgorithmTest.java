package com.shop.book.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookCombinationAlgorithmTest {

	private BookCombinationAlgorithm algorithm = new BookCombinationAlgorithm();

	@Test
	@DisplayName("should create book combinations based on total books")
	void testBookCombinationBasedOnTotalBooks() {
		int totalBookQuantity = 3;
		int[] rules = { 1, 2 };
		
		Integer[] bookCombination1 = { 1, 1, 1 };
		Integer[] bookCombination2 = { 2,1 };
		List<Integer> bookCombination1List = Arrays.asList(bookCombination1);
		List<Integer> bookCombination2List = Arrays.asList(bookCombination2);
		List<List<Integer>> bookCombinations = new ArrayList<>();
		bookCombinations.add(bookCombination1List);
		bookCombinations.add(bookCombination2List);

		List<List<Integer>> result = algorithm.createBookCombinationBasedUponTotalBooks(rules, totalBookQuantity);

		assertTrue(result.get(0).containsAll(bookCombinations.get(0)));
		assertNotNull(result);
	}
}
