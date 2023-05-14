package com.shop.book.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shop.book.model.Book;

@Component
public class BookMetaData {

	public Map<String, Integer> getBookCountMapBasedOnName(List<Book> books) {

		return books.stream().collect(Collectors.toMap(Book::getTitle, Book::getQuantity));
	}

}
