package com.shop.book.model;

import java.util.List;

public class BooksCombination {

	private List<String> booksName;

	private double price;
	private double discount;

	public BooksCombination(List<String> booksName, double price, double discount) {
		this.booksName = booksName;
		this.price = price;
		this.discount = discount;
	}

	public List<String> getBooksName() {
		return booksName;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

}
