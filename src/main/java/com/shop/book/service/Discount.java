package com.shop.book.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shop.book.model.Book;
import com.shop.book.model.DiscountDto;

@Component
public class Discount {

	private double getDiscountPercentage(int differentBooks) {

		double discountPercentage = 0;
		switch (differentBooks) {

		case 2:
			discountPercentage = 5;
			break;
		case 3:
			discountPercentage = 10;
			break;
		case 4:
			discountPercentage = 20;
			break;
		case 5:
			discountPercentage = 25;
			break;
		default:
			discountPercentage = 0;
		}

		return discountPercentage;
	}

	private double calculateDiscount(double totalPrice, double discountPercentage) {

		return totalPrice - totalPrice * (discountPercentage / 100);
	}

	public DiscountDto getDiscountOnCombination(double booksPrice, List<Book> bookList) {

		double discountPercentage = getDiscountPercentage(bookList.size());
		double discountedBooksPrice = calculateDiscount(booksPrice, discountPercentage);

		return new DiscountDto(discountedBooksPrice, discountPercentage);
	}

}
