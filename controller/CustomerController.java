package com.product.controller;

import com.product.dto.Customer;
import com.product.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setId(3);
		customer.setName("XYZ");
		customer.setEmail("xyz@mail.com");
		
		CustomerService customerService =new CustomerService();
		Customer c=customerService.saveCustomer(customer);
		
		if(c!=null);
		System.out.println(c.getId()+"done");
	}

}
