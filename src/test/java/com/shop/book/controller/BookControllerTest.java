package com.shop.book.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;

class BookControllerTest {

	private final BookController controller = new BookController();

	@Test
	@DisplayName("should return object type of BasketPrice")
	void testBookShoppingReturnType() {
		List<Book> bookList = new ArrayList<>();
		Book book = new Book("Java", 50, 1);
		bookList.add(book);

		BasketPrice result = controller.bookShopping(bookList);

		assertThat(result).isExactlyInstanceOf(BasketPrice.class);
	}

}
