package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionServlet")
public class HttpSessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		RequestDispatcher rd1 = request.getRequestDispatcher("/navbar.html");
		rd1.include(request, response);

		/* Create Session Object */
		HttpSession session = request.getSession();
		session.setAttribute("username", "surya.b.chettri@medstar.net");
		session.setAttribute("password", "schettri3104");
		
		writer.append("<h1>4. HttpSession</h1>");
		writer.append("<p>HttpSession provides methods that are used to create each user with unique objects. </p>");
		writer.append("<p>In this example, we create two attribute names 'username' and 'password' to store user's login credentials </p>");
		writer.append("<p><b>1. To create a session object, use </b></p>");
		writer.append("<p><i> HttpSession session = request.getSession(); </i></p>");
		writer.append("<p><i> session.setAttribute('username', 'surya.b.chettri@medstar.net'); </i></p>");
		writer.append("<p><i> session.setAttribute('password', 'schettri3104'); </i></p>");
		writer.append("<a href='HttpSessionServlet2'>ClickHere!</a>");	
		
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
