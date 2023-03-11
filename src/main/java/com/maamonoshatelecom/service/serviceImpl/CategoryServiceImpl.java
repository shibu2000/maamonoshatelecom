package com.maamonoshatelecom.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.CategoryEntity;
import com.maamonoshatelecom.Repo.CategoryRepo;
import com.maamonoshatelecom.Response.CategoryResponse;
import com.maamonoshatelecom.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public ResponseEntity<?> saveCategory(String category_name) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryname(category_name);
		CategoryEntity save = this.categoryRepo.save(categoryEntity);
		if (save.getId() > 0) {
			return ResponseEntity.accepted().body("Data Inserted");
		} else {
			return ResponseEntity.internalServerError().body("Data Insertion Failed");
		}
	}

	@Override
	public ResponseEntity<?> getcategory() {
		List<CategoryEntity> findAll = this.categoryRepo.findAll();

		List<CategoryResponse> categoryResponses = new ArrayList<>();

		findAll.forEach(category -> {
			CategoryResponse categoryResponse = new CategoryResponse();

			categoryResponse.setId(category.getId());
			categoryResponse.setCategoryname(category.getCategoryname());

			categoryResponses.add(categoryResponse);
		});

		return ResponseEntity.ok(categoryResponses);
	}

	@Override
	public ResponseEntity<?> putCategory(int id, String category_name) {
		Optional<CategoryEntity> findById = this.categoryRepo.findById(id);
		
		if (findById.isPresent()) {
			findById.get().setCategoryname(category_name);
			CategoryEntity save = this.categoryRepo.save(findById.get());
			return new ResponseEntity<CategoryEntity>(save, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<CategoryEntity>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> deleteCategory(int id) {
		Optional<CategoryEntity> categoryEntity = this.categoryRepo.findById(id);
		if (categoryEntity.isPresent()) {
			this.categoryRepo.deleteById(id);
			return new ResponseEntity<CategoryEntity>(HttpStatus.OK);
		} else {
			return new ResponseEntity<CategoryEntity>(HttpStatus.NOT_FOUND);
		}

	}

}