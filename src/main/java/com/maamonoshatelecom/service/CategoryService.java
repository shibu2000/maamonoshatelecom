package com.maamonoshatelecom.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.maamonoshatelecom.Entity.CategoryEntity;

public interface CategoryService {
	
	CategoryEntity saveCategory(CategoryEntity categoryEntity);
	List<CategoryEntity> getcategory();
	ResponseEntity<?> deleteCategory(int id);
	ResponseEntity<?> putCategory(CategoryEntity categoryEntity);

}
