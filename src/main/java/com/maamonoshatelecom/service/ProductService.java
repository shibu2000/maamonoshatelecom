package com.maamonoshatelecom.service;

import org.springframework.http.ResponseEntity;

import com.maamonoshatelecom.model.ProductModel;

public interface ProductService {

	ResponseEntity<?> saveProduct(ProductModel productModel);

	ResponseEntity<?> getProduct();

	ResponseEntity<?> deleteProduct(int id);

	ResponseEntity<?> putProduct(int id, ProductModel productModel);
	
	ResponseEntity<?> getProductByCatId(int id);
}
