package com.niu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niu.bean.Book;
import com.niu.bean.ShopCar;
import com.niu.service.IBookService;
import com.niu.service.Impl.BookServiceImpl;

@WebServlet("/AddShopCarServlet")
public class AddShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopCar shopCar;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.sendRedirect("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();

		// 从bookView.jsp接收传来的数据
		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		IBookService bookService = new BookServiceImpl();
		Book book = bookService.findBookById(id);
		
		shopCar = (ShopCar) session.getAttribute("shopCar");
		
		if(shopCar==null) {
			shopCar=new ShopCar();
		}
		
		//将书籍和购买的数量添加到购物车
		shopCar.addCar(book, num);
		session.setAttribute("shopCar", shopCar);
		
		request.getRequestDispatcher("jsp/shopCar.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
