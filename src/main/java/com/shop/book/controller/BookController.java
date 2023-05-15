package com.shop.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;
import com.shop.book.service.ShoppingBasket;
import com.shop.book.validation.BookRequestValidation;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookRequestValidation validation;
	
	@Autowired
	private ShoppingBasket shoppingBasket;

	@PostMapping("/shop")
	public BasketPrice bookShopping(@RequestBody List<Book> bookList) {

		validation.bookRequestValidation(bookList);
		return shoppingBasket.calculateBasketPrice(bookList);
	}

}
