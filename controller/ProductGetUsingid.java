package com.product.controller;

import com.product.dto.Product;
import com.product.service.ProductService;

public class ProductGetUsingid {
	public static void main(String[] args) {
		Product product = new Product();
		product.setId(1);
		ProductService productService=new ProductService();
		productService.selectProductById(product);
		
	}

}
