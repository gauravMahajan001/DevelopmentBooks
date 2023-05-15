package com.shop.book.util;

import com.shop.book.model.Book;

public class CreateBook {

	public static Book create(String title, double price, int quantity) {
		return new Book(title, price, quantity);

	}

}
