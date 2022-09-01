package com.techment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.exception.IdNotFoundException;
import com.techment.modal.Product;
import com.techment.service.ProductService;


@RestController
@RequestMapping("v1/api")

public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping(value = "product")
	ResponseEntity<Product> addNewProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>( productService.addProduct(product) , HttpStatus.OK );
	}
	
	@GetMapping(value = "products")
	ResponseEntity< List<Product> > getAllProducts()
	{
		return new ResponseEntity< List<Product> >( productService.getAllProducts() , HttpStatus.OK);
	}
	
	@GetMapping(value = "product/{id}")
	ResponseEntity<Product> getProductById(@PathVariable int id)
	{
		return new ResponseEntity<Product>( productService.getProductById(id) , HttpStatus.OK);
	}
	
	@PutMapping(value = "product/{id}")
	ResponseEntity<Product> updateProductById(@PathVariable int id, @RequestBody Product product) throws IdNotFoundException{
		return new ResponseEntity<Product>( productService.updateProductById(id , product) , HttpStatus.OK); 
	}
	
	@DeleteMapping(value = "product/{id}")
	ResponseEntity<String> deleteProductById(@PathVariable int id){
		return new ResponseEntity<String>( productService.deleteProductById(id) , HttpStatus.OK); 
	}
	
}
