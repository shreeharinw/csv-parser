package com.demoapp.spring.files.csv.model;

public class EcommerceModel {
	private String productName;
	private int retailPrice;
	private int discountedPrice;
	private String description;
	private String brand;

	public EcommerceModel(String productName, int retailPrice, int discountedPrice, String description, String brand) {
		this.productName = productName;
		this.retailPrice = retailPrice;
		this.discountedPrice = discountedPrice;
		this.description = description;
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public int getRetailPrice() {
		return retailPrice;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public String getDescription() {
		return description;
	}

	public String getBrand() {
		return brand;
	}
}
