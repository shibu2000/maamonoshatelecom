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

import com.maamonoshatelecom.Entity.CategoryEntity;
import com.maamonoshatelecom.service.CategoryService;

@RestController
@RequestMapping("/maamonoshatelecom/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@PostMapping("/save")
	CategoryEntity saveCategory(@RequestBody CategoryEntity categoryEntity) {
		CategoryEntity saveCategory = this.categoryService.saveCategory(categoryEntity);
		return saveCategory;
	}
	
	@GetMapping("/get")
	List<CategoryEntity> getCategory(){
		List<CategoryEntity> getcategory = this.categoryService.getcategory();
		return getcategory;
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<?> deleteCategory(@RequestParam int id) {
		ResponseEntity<?> deleteCategory = this.categoryService.deleteCategory(id);
		return deleteCategory;
	}
	
	@PutMapping("/update")
	ResponseEntity<?> putCategory(@RequestBody CategoryEntity categoryEntity) {
		ResponseEntity<?> putCategory = this.categoryService.putCategory(categoryEntity);
		return putCategory;
	}
	
}
