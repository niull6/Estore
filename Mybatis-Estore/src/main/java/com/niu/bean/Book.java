package com.niu.bean;

import org.apache.ibatis.type.Alias;

@Alias("Book")
public class Book {
	private Integer id;
	private String name;
	private double price;
	
	//包含书籍 类别
	private Category category;
	
	public Book() {
//		System.out.println("Book() ...");
	}
	public Book(String name, double price) {
//		System.out.println("Book(name,price) ...");
		this.name = name;
		this.price = price;
	}
	public Book(Integer id, String name, double price) {
//		System.out.println("Book(id,name,price) ...");
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Book(String name, double price, Category category) {
//		System.out.println("Book(name,price,category)...");
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public Book(Integer id, String name, double price, Category category) {
//		System.out.println("Book(name,price,category,category)...");
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
//		System.out.println("setId...");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
//		System.out.println("setName...");
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
//		System.out.println("setPrice...");
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
//		System.out.println("setCategory...");
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}
	/*@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}*/
	
}
