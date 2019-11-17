package com.niu.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.niu.bean.Category;
import com.niu.dao.CategoryDao;
import com.niu.service.ICategotyService;
import com.niu.utils.MySqlSessionFactory;

public class CategoryServiceImpl implements ICategotyService {
	
	SqlSession session = MySqlSessionFactory.openSession();
	CategoryDao categorydao = session.getMapper(CategoryDao.class);

	@Override
	public List<Category> findAllCategories() {
		
		List<Category> category = categorydao.findAllCategories();
		return category;
	}

	@Override
	public List<Category> findAllCategoryWithBooks() {
		
		List<Category> category = categorydao.findAllCategoryWithBooks();
		return category;
	}

	@Override
	public Category findCategoryWithBooksById(int id) {
		
		Category category = categorydao.findCategoryWithBooksById(id);
		return category;
	}

}
