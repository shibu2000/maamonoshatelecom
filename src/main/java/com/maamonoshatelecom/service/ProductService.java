package com.maamonoshatelecom.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.maamonoshatelecom.model.ProductModel;

public interface ProductService {

	ResponseEntity<?> saveProduct(ProductModel productModel);

	ResponseEntity<List<ProductModel>> getProduct();

	ResponseEntity<?> deleteProduct(int id);

	ResponseEntity<?> putProduct(int id, ProductModel productModel);
}
