package com.js.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BookCRUD;
import com.js.dto.Books;

@WebServlet(value="/view")
public class ViewAllBooks extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookCRUD bc = new BookCRUD();
		ArrayList<Books> book=bc.getAllBooks();
		if(book.isEmpty()) {
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg","No Books Available" );
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("viewall.jsp");
			req.setAttribute("data", book);
			rd.forward(req, resp);
		}
	}

}
