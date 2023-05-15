package com.shop.book.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;
import com.shop.book.service.ShoppingBasket;
import com.shop.book.util.CreateBook;
import com.shop.book.validation.BookRequestValidation;

class BookControllerTest {

	@InjectMocks
	private BookController controller;
	
	@Mock
	private BookRequestValidation validation;
	
	@Mock
	private ShoppingBasket shoppingBasket;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	@DisplayName("should return object type of BasketPrice")
	void testBookShoppingReturnType() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(CreateBook.create("Java", 50, 1));
		BasketPrice basketPrice = new BasketPrice();
		doReturn(basketPrice).when(shoppingBasket).calculateBasketPrice(bookList);
		
		BasketPrice result = controller.bookShopping(bookList);

		assertThat(result).isExactlyInstanceOf(BasketPrice.class);
	}
	
	@Test
	@DisplayName("should call validation once")
	void testBookListHasValidData() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(CreateBook.create("Code", 50, 1));
		doNothing().when(validation).bookRequestValidation(bookList);

		controller.bookShopping(bookList);

		verify(validation, atLeastOnce()).bookRequestValidation(bookList);
	}

}
