package com.product.service;

import com.product.dao.ProductDao;
import com.product.dto.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();

	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	//update
	public boolean UpdateProductById(int id,String name, String company) {
		return productDao.UpdateProductById(id,name ,company);
	}

	// for delete
	public boolean deleteProductById(int id) {
		return productDao.deleteProductById(2);
	}
	
	//getAll

	public void getAllProduct() {
		productDao.getAllProduct();
	}
	
	//get using id
	public Product selectProductById(Product product) {
		return productDao.selectProductById(product);
	}

}
