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
@WebServlet(value="/insert")
public class InsertBook extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Books b = new Books();
	b.setId(Integer.parseInt(req.getParameter("id")));
	b.setName(req.getParameter("bookname"));
	b.setPrice(Double.parseDouble(req.getParameter("price")));
	b.setAuthor(req.getParameter("author"));
	
	BookCRUD bc = new BookCRUD();
	int result = bc.insertBooK(b);
	if(result>0) {
		RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
		req.setAttribute("msg", "INSERTED SUCCESSFULLY");
		rd.forward(req, resp);
	}
	else {
		RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
		req.setAttribute("msg", "FAILED TO INSERT");
		rd.include(req, resp);
	}
}
}
