package com.niu.service.Impl;


import org.apache.ibatis.session.SqlSession;

import com.niu.bean.OrderLine;
import com.niu.dao.OrderLineDao;
import com.niu.service.IOrderLineService;
import com.niu.utils.MySqlSessionFactory;

public class OrderLineServiceImpl implements IOrderLineService {

	@Override
	public void insertOrderLine(OrderLine orderLine) {

		SqlSession sqlSession=MySqlSessionFactory.openSession();
		OrderLineDao mapper = sqlSession.getMapper(OrderLineDao.class);
		mapper.insertOrderLine(orderLine);
	}

}
