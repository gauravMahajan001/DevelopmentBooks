package com.shop.book.model;

import java.util.ArrayList;
import java.util.List;

public class BasketPrice {

	private double totalPrice;
	private List<BooksCombination> booksCombination = new ArrayList<>();
	private int totalBook;

	public double getTotalPrice() {
		return totalPrice;
	}

	public List<BooksCombination> getBooksCombination() {
		return booksCombination;
	}

	public int getTotalBook() {
		return totalBook;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice += totalPrice;
	}

	public void setBooksCombination(BooksCombination bookData) {
		this.booksCombination.add(bookData);

	}

	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook + this.totalBook;
	}

}
