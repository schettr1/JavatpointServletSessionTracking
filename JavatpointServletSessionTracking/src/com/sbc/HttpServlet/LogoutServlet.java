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

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.html");
		rd.include(request, response);
		
		//* Destroy the cookie object *//
		Cookie cookie[] = request.getCookies();
		if(cookie != null) {
			System.out.println(cookie[0].getValue());
			cookie[0].setMaxAge(0); 						/* set maximum age of cookie in seconds */
			response.addCookie(cookie[0]);
			writer.append("<p>** Cookie has been removed! </p>");
			writer.append("<p><b>1. To delete a cookie </b></p>");
			writer.append("<p><i>Cookie cookie[] = request.getCookies();  </i></p>");
			writer.append("<p><i>if(cookie != null) { </i></p>");
			writer.append("<p><i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; cookie[0].setMaxAge(0); </i></p>");
			writer.append("<p><i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; response.addCookie(cookie[0]); </i></p>");
			writer.append("<p><i>} </i></p>");
		}
		
		//* Destroy the session object *//
		HttpSession session = request.getSession();	

		if(session.getAttribute("username") != null) {
			System.out.println(session.getAttribute("username").toString());
			System.out.println(session.getAttribute("password").toString());
			session.invalidate();		/* destroy session object of current user. You can re-assign new values to session object */
			
			writer.append("<p>** Session object has been removed! </p>");
			writer.append("<p><b>2. To delete session object </b></p>");
			writer.append("<p><i>HttpSession session = request.getSession(); </i></p>");
			writer.append("<p><i>session.invalidate(); </i></p>");
			writer.close();
		}

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
