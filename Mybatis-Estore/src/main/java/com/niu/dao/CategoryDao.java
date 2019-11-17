package com.niu.dao;

import java.util.List;
import com.niu.bean.Category;

public interface CategoryDao {
	
	public List<Category> findAllCategories();
	
	/*
	 * 查询所有的分类以及分类下所有图书
	 */
	public List<Category> findAllCategoryWithBooks();
	
	/*
	 * 通过id查询分类以及该分类下的所有图书
	 */
	public Category findCategoryWithBooksById(int id);

}