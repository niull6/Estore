package com.niu.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.bean.Book;
import com.niu.service.IBookService;
import com.niu.service.Impl.BookServiceImpl;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookService bookService = new BookServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String jid = request.getParameter("id");
		int id=Integer.parseInt(jid);
		Book book = bookService.findBookById(id);
		request.setAttribute("book", book);
		
		ServletContext application = this.getServletContext();
		application.setAttribute("customer", application.getAttribute("customer"));
		

		request.getRequestDispatcher("jsp/bookView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
