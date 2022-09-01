package com.techment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.ProductRepository;
import com.techment.exception.IdNotFoundException;
import com.techment.modal.Product;


@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired
	   ProductRepository productRepository;
		
		@Override
		public Product addProduct(Product product) {
			return productRepository.save(product);
		}

		@Override
		public List<Product> getAllProducts() {
			return productRepository.findAll();
		}

		@Override
		public Product getProductById(int id) {
			// TODO Auto-generated method stub
			return productRepository.findById(id).get();
		}

		@Override
		public Product updateProductById(int id, Product product) throws IdNotFoundException {
			// TODO Auto-generated method stub
			Product updatedProduct = null ;
			boolean exists = productRepository.existsById(id);
			
			if(exists) {
				updatedProduct = productRepository.findById(id).get();
				updatedProduct.setProductName(product.getProductName());
				updatedProduct.setProductPrice((product.getProductPrice()));
				updatedProduct.setProductCategory(product.getProductCategory());
				productRepository.save(updatedProduct);
			}
			else {
				throw new IdNotFoundException("Product with Id " + id + " not Found...");
			}
			return updatedProduct;
		}

		@Override
		public String deleteProductById(int id) {
			// TODO Auto-generated method stub
			productRepository.deleteById(id);
			return "Product Deleted";
		}

		

}
