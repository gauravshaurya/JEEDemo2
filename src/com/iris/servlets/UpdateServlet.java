/*
 * package com.iris.servlets;
 * 
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.iris.daos.CustomerDao; import com.iris.daosimpl.CustomerDaoImpl;
 * 
 * @WebServlet("/updateServlet") public class UpdateServlet extends HttpServlet
 * { private static final long serialVersionUID = 1L;
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("text/html"); PrintWriter out=response.getWriter();
 * 
 * int id = Integer.parseInt(request.getParameter("cid"));
 * 
 * CustomerDao custDao = new CustomerDaoImpl(); try {
 * custDao.updateCustomer(id); } catch (Exception e) { e.printStackTrace(); }
 * 
 * out.
 * println("<div align='center' style='color:red'>Successfully updated.</div>");
 * RequestDispatcher rd=request.getRequestDispatcher("viewAllCustomers");
 * rd.include(request, response); }
 * 
 * }
 */