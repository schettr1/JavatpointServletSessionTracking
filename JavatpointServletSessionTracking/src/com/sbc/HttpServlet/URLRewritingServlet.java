package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/URLRewritingServlet")
public class URLRewritingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String ID = request.getParameter("id");
		PrintWriter writer = response.getWriter();
		
		RequestDispatcher rd1 = request.getRequestDispatcher("/navbar.html");
		rd1.include(request, response);
		
		writer.append("ID : " + ID);
		writer.append("<p><i>The value of ID is retrieved from the url of this page.</i></p>");
		writer.append("<h1>3. URL Rewriting</h1>");
		writer.append("<p>In URL rewriting, we append a variable and its value at the end of the URL. </p>");
		writer.append("<p>We can send parameter name/value pairs using the following format:</p>");
		writer.append("<p><i> href = ''url?x=1&y=2&z=zebra'' </i></p>");
	
		writer.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
