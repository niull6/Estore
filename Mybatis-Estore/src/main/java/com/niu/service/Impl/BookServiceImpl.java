package com.niu.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.niu.bean.Book;
import com.niu.dao.BookDao;
import com.niu.service.IBookService;
import com.niu.utils.MySqlSessionFactory;

public class BookServiceImpl implements IBookService {

	SqlSession session = MySqlSessionFactory.openSession();

	BookDao bookdao = session.getMapper(BookDao.class);

	@Override
	public List<Book> findAllBooks() {
		List<Book> books = bookdao.findAllBooks();
		return books;
	}

	@Override
	public Book findBookById(int id) {
		Book book = bookdao.findBookById(id);
		return book;
	}

}
