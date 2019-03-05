package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Creating Servlet by extending HttpServlet
 */

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		if(username.equals("user") && password.equals("pass")) {
			/* lets assume the user with this username & password has 'id : 2600860' */
			Cookie cookie = new Cookie("id", "2600860"); 
			response.addCookie(cookie);
						
			RequestDispatcher rd1 = request.getRequestDispatcher("/navbar.html");
			rd1.include(request, response);
			
			writer.append("ID: " + "2600860");
			
			writer.append("<h1>Session Tracking in Servlet</h1>");
			writer.append("<p>There are 4 techniques used in Session Tracking-  </p>");
			writer.append("<h3>i. Cookie </h3>");
			writer.append("<h3>ii. Hidden Form Field </h3>");
			writer.append("<h3>iii. URL Re-writing </h3>");
			writer.append("<h3>iv. HttpSession </h3><br/>");
			writer.append("<p><b>1. To create a cookie </b></p>");
			writer.append("<p><i>Cookie cookie = new Cookie('ID', '2600860'); </i></p>");
			writer.append("<p><b>2. To add cookie to the response </b></p>");
			writer.append("<p><i>response.addCookie(cookie); </i></p>");
			
			writer.close();
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			
			writer.append("<h3>Username is 'User' & Password is 'Pass'</h3>");
			
		}
		
		
			
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
			.append("Served at: ")
			.append(request.getContextPath());
		
	}

}
