package com.product.controller;

import com.product.dto.Product;
import com.product.service.ProductService;

public class ProductUpdate {
	public static void main(String[] args) {
		ProductService productService=new ProductService();
	    boolean res=productService.UpdateProductById(3,"pqr","abc");
		System.out.println(res);
		
	}

}
