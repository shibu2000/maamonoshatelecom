package com.maamonoshatelecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maamonoshatelecom.service.CategoryService;

@RestController
@RequestMapping("/maamonoshatelecom/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/save")
	ResponseEntity<?> saveCategory(@RequestParam("category_name") String category_name) {
		return this.categoryService.saveCategory(category_name);

	}

	@GetMapping("/get")
	ResponseEntity<?> getCategory() {
		ResponseEntity<?> categoryList = this.categoryService.getcategory();
		return categoryList;
	}

	@DeleteMapping("/delete")
	ResponseEntity<?> deleteCategory(@RequestParam int id) {
		ResponseEntity<?> deleteCategory = this.categoryService.deleteCategory(id);
		return deleteCategory;
	}

	@PutMapping("/update")
	ResponseEntity<?> putCategory(@RequestParam("id") int id, @RequestParam("category_name") String category_name) {
		ResponseEntity<?> putCategory = this.categoryService.putCategory(id, category_name);
		return putCategory;
	}

}
