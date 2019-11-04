package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.daos.CustomerDao;
import com.iris.daosimpl.CustomerDaoImpl;
import com.iris.models.Customer;


@WebServlet("/register")
public class RegisterationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
    
    public RegisterationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		response.setContentType("text/html");
		Customer cust = new Customer();
		
		String s2=request.getParameter("customerName");
		String s3=request.getParameter("email");
		String s4=request.getParameter("gender");
		String s5=request.getParameter("city");
		String s6=request.getParameter("password");

		cust.setCustomerName(s2);
		cust.setEmail(s3);
		cust.setGender(s4);
		cust.setCity(s5);
		cust.setPassword(s6);
		
		PrintWriter out=response.getWriter();
		CustomerDao custDao=new CustomerDaoImpl();
		custDao.registerCustomer(cust);
		
		out.println("Successfully Inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	

}