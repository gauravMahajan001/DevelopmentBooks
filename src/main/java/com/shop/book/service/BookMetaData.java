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
	
	public Book getBookAndReduceAvailableCount(int bookIndex, List<Book> booksList,
			Map<String, Integer> bookCountMapBasedOnName) {

		Book distinctBook = null;

		while (distinctBook == null && bookIndex < booksList.size()) {

			Book book = booksList.get(bookIndex++);
			int bookCount = bookCountMapBasedOnName.get(book.getTitle());

			if (bookCount > 0) {

				bookCountMapBasedOnName.put(book.getTitle(), bookCount - 1);
				distinctBook = book;
			}

		}
		return distinctBook;
	}

}
