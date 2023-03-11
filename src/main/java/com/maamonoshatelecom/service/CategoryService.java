package com.maamonoshatelecom.service;

import org.springframework.http.ResponseEntity;

public interface CategoryService {
	
	ResponseEntity<?> saveCategory(String category_name);
	ResponseEntity<?> getcategory();
	ResponseEntity<?> deleteCategory(int id);
	ResponseEntity<?> putCategory(int id, String category_name);

}
