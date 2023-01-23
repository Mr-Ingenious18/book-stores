package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BookCRUD;
import com.js.dto.Books;
@WebServlet(value="/update2")
public class UpdateStage2 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Books b =new Books();
	b.setId(Integer.parseInt(req.getParameter("id")));
	b.setName(req.getParameter("bookname"));
	b.setAuthor(req.getParameter("author"));
	b.setPrice(Double.parseDouble(req.getParameter("price")));
	
	BookCRUD bc = new BookCRUD();
	int result = bc.updateBookById(b.getId(), b);
	if(result>0) {
		RequestDispatcher rd = req.getRequestDispatcher("view");
		rd.forward(req, resp);
	}
	else {
		RequestDispatcher rd =req.getRequestDispatcher("result.jsp");
		req.setAttribute("msg", "Failed to update");
		rd.forward(req, resp);
	}
}
}
