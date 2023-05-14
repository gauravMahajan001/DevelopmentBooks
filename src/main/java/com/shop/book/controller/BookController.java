package com.shop.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.book.model.BasketPrice;
import com.shop.book.model.Book;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@PostMapping("/shop")
	public BasketPrice bookShopping(@RequestBody List<Book> bookList) {

		return new BasketPrice();
	}

}
