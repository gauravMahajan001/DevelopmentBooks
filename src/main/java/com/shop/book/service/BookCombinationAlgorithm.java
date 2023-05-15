package com.shop.book.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * e.g. if total book is 8 and rule {1,2,3,4,5} then result is [[1, 1, 1, 1, 1,
 * 1, 1, 1], [2, 1, 1, 1, 1, 1, 1], [3, 1, 1, 1, 1, 1], [2, 2, 1, 1, 1, 1], [4,
 * 1, 1, 1, 1], [3, 2, 1, 1, 1],....}
 *
 */
@Component
public class BookCombinationAlgorithm {

	public List<List<Integer>> createBookCombinationBasedUponTotalBooks(int[] rules, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int start = 0;
		combination(result, new ArrayList<>(), rules, target, start);

		return result;
	}

	private void combination(List<List<Integer>> result, List<Integer> temp, int[] rules, int remain, int start) {

		if (remain < 0) {

			return;
		} else if (remain == 0) {
			ArrayList<Integer> reverseList = new ArrayList<>(temp);
			Collections.reverse(reverseList);
			result.add(reverseList);

		} else {

			for (int i = start; i < rules.length; i++) {

				temp.add(rules[i]);

				combination(result, temp, rules, remain - rules[i], i);
				temp.remove(temp.size() - 1);
			}
		}
	}
}