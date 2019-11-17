package com.niu.service.Impl;

import org.apache.ibatis.session.SqlSession;

import com.niu.bean.Order;
import com.niu.dao.OrderDao;
import com.niu.service.IOrderService;
import com.niu.utils.MySqlSessionFactory;

public class OrderServiceImpl implements IOrderService {

	@Override
	public void insertOrder(Order order) {
		
		SqlSession sqlSession = MySqlSessionFactory.openSession();
		
		OrderDao mapper = sqlSession.getMapper(OrderDao.class);
		
		mapper.insertOrder(order);

	}

}
