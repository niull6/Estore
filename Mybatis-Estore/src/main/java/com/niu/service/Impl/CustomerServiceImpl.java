package com.niu.service.Impl;


import org.apache.ibatis.session.SqlSession;

import com.niu.bean.Customer;
import com.niu.dao.CustomerDao;
import com.niu.service.ICustomerService;
import com.niu.utils.MySqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService {

	SqlSession session = MySqlSessionFactory.openSession(true);
	CustomerDao customerdao = session.getMapper(CustomerDao.class);

	@Override
	public void register(Customer customer) throws Exception {

		//Customer selectcustomer = customerdao.selectCustomerByUsername(customer.getUsername());
		
		Customer selectcustomer = customerdao.selectCustomerByUsername(customer.getUsername());

		if (selectcustomer != null) {
			throw new Exception("用户已注册！");
		}
		if (customer.getUsername() == null || customer.getUsername().equals("")) {
			throw new Exception("用户名为空或空字符串");
		}
		if (customer.getPassword() == null || customer.getPassword().equals("")) {
			throw new Exception("密码为空或空字符串");
		}
		customerdao.insertCustomer(customer);
	}

	@Override
	public Customer login(String username, String password) throws Exception {
		if (username == null || username == "") {
			throw new Exception("请输入用户名");
		}
		if (password == null || password == "") {
			throw new Exception("请输入密码！");
		}
		// 数据库用户
		Customer customer=null;
		customer = customerdao.selectCustomerByUsername(username);

		if (customer == null) {
			throw new Exception("不存在该用户！");
		}
		
		String name = customer.getUsername();
		String pwd = customer.getPassword();
		
		if (!username.equals(name)) {
			throw new Exception("不存在该用户！！");
		}
		if (!password.equals(pwd)) {
			throw new Exception("密码错误！");
		}
		return customer;
	}

}
