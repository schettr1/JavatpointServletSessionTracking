package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		RequestDispatcher rd1 = request.getRequestDispatcher("/navbar.html");
		rd1.include(request, response);
		
		Cookie cookie[] = request.getCookies();
		if(cookie.length > 0) {
			String id = cookie[0].getValue();
			writer.append("ID: " + id);
			writer.append("<p>User ID is retrieved from the second request (with cookie) made by the client. </p>");
		}
		else {
			writer.append("Invalid Login Credentials. Please login first.");
		}
		
		RequestDispatcher rd2 = request.getRequestDispatcher("/cookie.html");
		rd2.include(request, response);
		
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
