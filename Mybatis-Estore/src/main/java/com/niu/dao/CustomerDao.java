package com.niu.dao;

import com.niu.bean.Customer;

public interface CustomerDao {

	//ע�����û�
	public void insertCustomer(Customer customer);
	
	//�����û�����ѯ�û�
	public Customer selectCustomerByUsername(String username);
}
