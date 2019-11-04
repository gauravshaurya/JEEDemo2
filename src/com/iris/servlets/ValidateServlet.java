package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.daos.CustomerDao;
import com.iris.daosimpl.CustomerDaoImpl;
import com.iris.models.Customer;


@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			int s1=Integer.parseInt(request.getParameter("customerId"));
			String s2=request.getParameter("password");
			
			CustomerDao custDao = new CustomerDaoImpl();
			Customer cObj=custDao.validateCustomer(s1, s2);
			
			if(cObj!=null) {
				
				String role=cObj.getRole();
				HttpSession session=request.getSession();
				session.setAttribute("custObj",cObj);
				
				
				 if(role.equals("customer")) { 
					 RequestDispatcher rd=request.getRequestDispatcher("CustomerServlet"); 
					 rd.include(request,response); 
				 } 
				 else if(role.equals("admin")) { 
					 RequestDispatcher rd=request.getRequestDispatcher("AdminServlet"); 
					 rd.include(request,response); 
				 }
				 else {
				 
				 }
				
			}
			else {
				out.println("<div align='center' style='color:red'>Customer Id or password is incorrect.</div>");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
					
			}
		} 
	}