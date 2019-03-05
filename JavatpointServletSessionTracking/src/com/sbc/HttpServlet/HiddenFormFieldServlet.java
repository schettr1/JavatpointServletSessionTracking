package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HiddenFormFieldServlet")
public class HiddenFormFieldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		RequestDispatcher rd1 = request.getRequestDispatcher("/navbar.html");
		rd1.include(request, response);
		
		writer.append("<h1>2. Hidden Form Field</h1>");
		writer.append("<p>In this technique, value is stored in one of the form elements and that form element is set to hidden </p>");
		writer.append("<p>When the form is submitted, data is passed to another servlet or .jsp/.html page </p>");
	
		writer.append("<h3>1. To store value in form element using hidden attribute </h3>");
		
		RequestDispatcher rd2 = request.getRequestDispatcher("/hidden_form_field.html");
		rd2.include(request, response);
		
		writer.append("<h3>2. To retrieve ID value in another Servlet/JSP page</h3>");
		writer.append("<p><i>String ID = request.getParameter('ID'); </i></p>");
		
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
