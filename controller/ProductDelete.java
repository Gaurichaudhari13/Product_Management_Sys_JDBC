package com.product.controller;

import com.product.service.ProductService;

public class ProductDelete {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		boolean res = productService.deleteProductById(2);
		System.out.println(res);

	}

}
