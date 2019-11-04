package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.models.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		Customer c=(Customer)session.getAttribute("custObj");
		
		out.println("<div align='right'>");
		out.println("Welcome : "+c.getCustomerName()+"</div><hr/>");
		out.println("<div align='center'>");
		out.println("Welcome Customer<br/>");
		out.println("<a href='viewProfile'>View Profile</a><br/>");
		out.println("<a href='#'>Change Password</a><br/>");
		out.println("</div>");
	}

}
