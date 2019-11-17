package com.niu.dao;

import java.util.List;

import com.niu.bean.Book;

public interface BookDao {

	public List<Book> findAllBooks();
	
	public Book findBookById(int id);
}
