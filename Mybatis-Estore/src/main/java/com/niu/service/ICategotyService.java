package com.niu.service;

import java.util.List;

import com.niu.bean.Category;

public interface ICategotyService {
	public List<Category> findAllCategories();
	
	public List<Category> findAllCategoryWithBooks();
	
	public Category findCategoryWithBooksById(int id);
	
}
