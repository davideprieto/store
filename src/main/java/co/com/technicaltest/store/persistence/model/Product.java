package co.com.technicaltest.store.persistence.model;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String name;
	private String description;
	private int price;
	private int amount;
	
	
	
	
	public Product(String name, String description, int price, int amount) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
} 
