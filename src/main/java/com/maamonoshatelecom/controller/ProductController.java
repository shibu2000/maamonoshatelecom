package com.maamonoshatelecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maamonoshatelecom.model.ProductModel;
import com.maamonoshatelecom.service.ProductService;

@RestController
@RequestMapping("/maamonoshatelecom/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	ResponseEntity<?> saveCategory(@RequestBody ProductModel productModel) {
		ResponseEntity<?> saveProduct = this.productService.saveProduct(productModel);
		return saveProduct;
	}
	
	@GetMapping("/get")
	ResponseEntity<?> getCategory(){
		ResponseEntity<List<ProductModel>> product = this.productService.getProduct();
		return product;
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<?> deleteCategory(@RequestParam int id) {
		ResponseEntity<?> deleteProduct = this.productService.deleteProduct(id);
		return deleteProduct;
	}
	
	@PutMapping("/update")
	ResponseEntity<?> putCategory(@RequestParam int id, @RequestBody ProductModel productModel) {
		ResponseEntity<?> putProduct = this.productService.putProduct(id,productModel);
		return putProduct;
	}
	
	@GetMapping("/get-product-by-cid")
	ResponseEntity<?> getProductByCatId(@RequestParam int id){
		ResponseEntity<?> productByCatId = this.productService.getProductByCatId(id);
		return productByCatId;
	}
	
	
	
}
