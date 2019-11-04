package com.iris.daos;

import java.util.List;

import com.iris.models.Customer;

public interface CustomerDao {
	
	public boolean registerCustomer(Customer cust) throws Exception;
	public Customer validateCustomer(int customerId,String password);
	public List<Customer> getAllCustomers();
	public boolean deleteCustomer(int id) throws Exception;
	/* public boolean updateCustomer(int id) throws Exception; */

}