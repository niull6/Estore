package com.niu.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

/*
 * 购物车类
 * 	属性： map集合，键为订单编号，值为订单项
 * 	方法：添加书籍 到 购物车
 * 		获取所有的订单项
 */
@Alias("ShopCar")
public class ShopCar {
	//一个购物车 包含多个 订单项
		//补充：声明为成员变量，确保每次添加的订单项添加到同一个购物车中
		//Integer存放了bookId，目的：如果重复添加了一本书，此书在购物车中原有的数量上 +1
	private Map<Integer, OrderLine> car = new HashMap<Integer, OrderLine>();
	
	//将书籍、数量 封装得到一个订单项，最终 添加到购物车
	public void addCar(Book book,int num) {
		//查看购物车中是否 已经存在该订单项中书籍
		int bookId = book.getId();
		OrderLine line2 = car.get(bookId);
		//如果购物车中尚未添加该书籍，则新建订单项，添加到集合
		if(line2 == null) {
			OrderLine line = new OrderLine();
			line.setBook(book);
			line.setNum(num);
			
			//如果第一次购买该书籍，直接添加到购物车
			car.put(bookId, line);
		}else {
			//如果购物车中已经有了该书籍，则修改购物车中书籍数量即可
			line2.setNum(num+line2.getNum());
		}
	}
	
	//清空购物车
	public void clear() {
		car.clear();
	}
	
	//获取所有订单项
	public Collection<OrderLine> getLines() {
		return car.values();
	}
	
	//获取 订单项 个数
	public int getCount() {
		return car.values().size();
	}
	
	//获取购物车的总金额
	public double getTotal() {
		double total = 0;
		for (Integer id : car.keySet()) {
			OrderLine line = car.get(id);
			total += line.getNum()*line.getBook().getPrice();
		}
		return total;
	}

	//根据书籍id删除 订单项
	public void remove(int id) {
		car.remove(id);
	}
	
	//修改购物车指定订单项数量
	public void change(int bookId,int num) {
		OrderLine line = car.get(bookId);
		if(line != null)
			line.setNum(num);
	}
	
}
