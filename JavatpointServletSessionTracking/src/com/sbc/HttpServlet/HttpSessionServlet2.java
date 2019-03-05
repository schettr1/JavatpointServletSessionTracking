package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionServlet2")
public class HttpSessionServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		RequestDispatcher rd1 = request.getRequestDispatcher("/navbar.html");
		rd1.include(request, response);

		/* Retrieve Session Object */
		HttpSession session = request.getSession();
		String username = null;
		String password = null;
		
		if(session != null) {
			username = session.getAttribute("username").toString();
			password = session.getAttribute("password").toString();
		}
		
		writer.append("<p><b>Username : </b><i>" + username + "</i></p>");
		writer.append("<p><b>Password : </b><i>" + password + "</i></p>");
		
		writer.append("<p>Username and Password are retrieved by using HttpSession. </p>");
		writer.append("<p><b>1. To retrieve session object </b></p>");
		writer.append("<p><i> HttpSession session = request.getSession(); </i></p>");
		writer.append("<p><i> if(session != null) </i></p>");
		writer.append("<p><i> {  </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;  String username = (String) session.getAttribute('username'); </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;  String password = (String) session.getAttribute('password'); </i></p>");
		writer.append("<p><i> } </i></p>");
		writer.append("<a href='HttpSessionServlet2'>ClickHere!</a>");
		
		
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
