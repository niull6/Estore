package com.niu.bean;

import org.apache.ibatis.type.Alias;

/*
 * 订单项的用处有两个地方：
 * 	1.用户添加书籍到购物车
 * 		购物车对象中包含  key-value: 书籍id-订单项   因为购买同一本书时需要合并信息。
 * 	2.用户下订单结算
 */

@Alias("OrderLine")
public class OrderLine {
	// 订单项编号，与数据库中主键id对应，购物车相关功能不关心
	private Integer id;
	// 书籍数量
	private int num;
	// 对应的书籍
	private Book book;
	// 对应的订单
	private Order order;
	// 对应书籍的ID
	private Integer bookid;

	// 对应的订单(order)的ID
	private Integer orderid;

	public OrderLine() {
	}

	public OrderLine(int num) {
		this.num = num;
	}

	public OrderLine(Integer id, int num) {
		this.id = id;
		this.num = num;
	}

	public OrderLine(Integer id, int num, Book book) {
		this.id = id;
		this.num = num;
		this.book = book;
	}

	public OrderLine(Integer id, int num, Integer bookid, Integer orderid) {
		super();
		this.id = id;
		this.num = num;
		this.bookid = bookid;
		this.orderid = orderid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", book=" + book + "]";
	}

}
