package com.product.service;

import com.product.dao.CustomerDao;
import com.product.dto.Customer;
import com.product.dto.Product;

public class CustomerService {
	CustomerDao customerDao=new CustomerDao();
	public Customer saveCustomer (Customer customer) {
		return customerDao.saveCustomer(customer);
}
	// for delete
		public boolean deleteCustomerById(int id) {
			return customerDao.deleteCustomerById(1);
		}
		
		// for update
		public boolean updateCustomerById(int id) {
			return customerDao.updateCustomerById(3);
		}
		//getAll
		public void getAllCustomer() {
			customerDao.getAllCustomer();
		}
		//get using id
		public Customer selectCustomerById(Customer customer) {
			return customerDao.selectCustomerById(customer);
		}


}
