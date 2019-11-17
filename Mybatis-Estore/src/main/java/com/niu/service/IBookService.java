package com.niu.service;

import java.util.List;

import com.niu.bean.Book;

public interface IBookService {

	public List<Book> findAllBooks();
	
	public Book findBookById(int id);
}
