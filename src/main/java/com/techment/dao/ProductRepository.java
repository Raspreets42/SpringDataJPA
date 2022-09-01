package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.modal.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
}
