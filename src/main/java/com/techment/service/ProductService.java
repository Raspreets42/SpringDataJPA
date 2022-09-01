package com.techment.service;

import java.util.List;

import com.techment.exception.IdNotFoundException;
import com.techment.modal.Product;

public interface ProductService {
	Product addProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
	Product updateProductById(int id , Product product) throws IdNotFoundException;
	
	String deleteProductById(int id);
}
