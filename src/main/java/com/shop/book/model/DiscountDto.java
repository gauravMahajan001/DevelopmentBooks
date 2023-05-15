package com.shop.book.model;

public class DiscountDto {

	private double discountedBookPrice;
	private double discountPercantage;

	public DiscountDto(double discountedBookPrice, double discountPercantage) {
		this.discountedBookPrice = discountedBookPrice;
		this.discountPercantage = discountPercantage;
	}

	public double getDiscountedBookPrice() {
		return discountedBookPrice;
	}

	public double getDiscountPercantage() {
		return discountPercantage;
	}

	public void setDiscountedBookPrice(double discountedBookPrice) {
		this.discountedBookPrice = discountedBookPrice;
	}

	public void setDiscountPercantage(double discountPercantage) {
		this.discountPercantage = discountPercantage;
	}

}
