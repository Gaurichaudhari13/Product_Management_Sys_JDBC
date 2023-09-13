package com.product.controller;

import com.product.service.CustomerService;

public class CustomerUpdate {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		boolean res = customerService.updateCustomerById(3);
	}

}
