package com.niu.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niu.bean.Customer;
import com.niu.bean.Order;
import com.niu.bean.OrderLine;
import com.niu.bean.ShopCar;
import com.niu.service.IOrderLineService;
import com.niu.service.IOrderService;
import com.niu.service.Impl.OrderLineServiceImpl;
import com.niu.service.Impl.OrderServiceImpl;



/**
 * 购物车界面 点击 提交订单，跳转于此
 * 1.在 e_order 表中插入一条记录
 * 2.在 e_orderline 中插入每个订单项记录
 * 3.清空当前购物车
 * 4.跳转界面至 成功提交订单界面
 */
@WebServlet("/submitOrder")
public class SubmitOrderServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Customer = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			
		HttpSession session = request.getSession();
		
		//从容器中获取customer和shopCar
		Customer customer = (Customer) this.getServletContext().getAttribute("customer");
		ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");	
		System.out.println(customer);
		System.out.println(shopCar);
		
		IOrderService orderService = new OrderServiceImpl();
		
		//将total，orderDate，customer,lines封装成 order对象
		Order order = new Order();
		
		//此行代码必不可少！原因：dao层反射调用order.getTotal();而getgetTotal()使用line来计算
		order.setLines(shopCar.getLines());
		order.setCustomer(customer);
		order.setOrderDate(new Date());
		order.setTotal(shopCar.getTotal());
		
		System.out.println(order + "===========================dao层");
		//先默认收货人和收货地址为当前登录用户。等后期有时间完成添加新的收货人和收货地址
		orderService.insertOrder(order);
		
		IOrderLineService orderLineService = new OrderLineServiceImpl();
		
		//将当前订单中的一个个订单项插入到e_orderline表中
		Collection<OrderLine> lines = shopCar.getLines();
		for(OrderLine ol : lines) {
			
			ol.setOrder(order);
			
			orderLineService.insertOrderLine(ol);
		}
		//清空购物车
		shopCar.clear();
		
		request.getRequestDispatcher("jsp/confirmSuccess.jsp").forward(request, response);
		
	}
}

