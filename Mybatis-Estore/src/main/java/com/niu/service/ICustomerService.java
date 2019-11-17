package com.niu.service;

import com.niu.bean.Customer;

public interface ICustomerService {

	public void register(Customer customer) throws Exception;
	
	public Customer login(String username,String password) throws Exception;
}
