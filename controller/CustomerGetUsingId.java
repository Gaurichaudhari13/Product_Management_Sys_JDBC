package com.product.controller;

import com.product.service.CustomerService;

public class CustomergetAll {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		customerService.getAllCustomer();

	}

}
