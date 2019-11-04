package com.iris.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iris.daos.CustomerDao;
import com.iris.models.Customer;
import com.iris.utility.ConnectionProvider;

public class CustomerDaoImpl implements CustomerDao {
	
	static Connection conn = ConnectionProvider.getConn();

	@Override
	public boolean registerCustomer(Customer custm) {
	
	try {

		PreparedStatement ps = conn.prepareStatement("insert into customer1 values(customerseq.nextval,?,?,?,?,?,'customer')");
		ps.setString(1, custm.getCustomerName());
		ps.setString(2, custm.getGender());
		ps.setString(3, custm.getEmail());
		ps.setString(4, custm.getPassword());		
		ps.setString(5, custm.getCity() );
		
		
		int i = ps.executeUpdate();
		if(i!=0) {
		return true;
		}
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		return false;
}
	@Override
	public Customer validateCustomer(int customerId, String password){
		try {
			PreparedStatement ps=conn.prepareStatement("select * from customer1 where CustomerId=? and Password=?");
			ps.setInt(1,customerId);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Customer cObj=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				return cObj;
			}
			}
		catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from Customer1 where role='customer'");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Customer cObj=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				customerList.add(cObj);
				
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public boolean deleteCustomer(int customerId) throws Exception{
		PreparedStatement ps=conn.prepareStatement("delete from customer1 where customerId=?");
		ps.setInt(1, customerId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * public boolean updateCustomer(int customerId) throws Exception{
	 * PreparedStatement ps=conn.
	 * prepareStatement("update customer1 set Name=?, Gender=?, Email=?, Password=?, City=?, where customerId=?"
	 * );
	 * 
	 * ps.setString(1, Name); ps.setString(2, Gender); ps.setString(3, Email);
	 * ps.setString(4, Password); ps.setString(5, City); ps.setInt(6, customerId);
	 * ResultSet rs=ps.executeQuery(); if(rs.next()) { return true; } else { return
	 * false; } }
	 */
}