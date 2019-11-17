package com.niu.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Category")
public class Category {
	private Integer id;
	private String name;
	private String info;
	
	private List<Book> books = new ArrayList();
	
	public Category() {
//		System.out.println("Category()...");
	}
	public Category(String name, String info) {
		this.name = name;
		this.info = info;
	}
	public Category(Integer id, String name, String info) {
		this.id = id;
		this.name = name;
		this.info = info;
	}
	public Category(Integer id, String name, String info, List<Book> books) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.books = books;
	}
	public Integer getId() {
		return id;
	}
	public void ListId(Integer id) {
//		System.out.println("ListId()...");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void ListName(String name) {
//		System.out.println("ListName()...");
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void ListInfo(String info) {
//		System.out.println("ListInfo()...");
		this.info = info;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void ListBooks(List<Book> books) {
//		System.out.println("ListBooks()...");
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", info=" + info + ", books.size: " + (books != null ? books.size() : 0) + "]";
	}
}
