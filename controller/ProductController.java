package com.product.controller;

import com.product.dto.Product;
import com.product.service.ProductService;

public class ProductController {
	public static void main(String[] args) {
		Product product =new Product();
		product.setId(1);
		product.setName("ABC");
		product.setcompany("abc@gmail.com");
		
		ProductService productService=new ProductService();
		Product p=productService.saveProduct(product);
		if(p!=null);
		System.out.println(p.getId() +"saved");
		
	}

}
