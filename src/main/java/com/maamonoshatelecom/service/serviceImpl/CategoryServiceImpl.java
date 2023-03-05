package com.maamonoshatelecom.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.CategoryEntity;
import com.maamonoshatelecom.Repo.CategoryRepo;
import com.maamonoshatelecom.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
		CategoryEntity save = this.categoryRepo.save(categoryEntity);
		return save;
	}

	@Override
	public List<CategoryEntity> getcategory() {
		List<CategoryEntity> findAll = this.categoryRepo.findAll();
		return findAll;
	}


	@Override
	public ResponseEntity<?> putCategory(CategoryEntity categoryEntity) {
		Optional<CategoryEntity> findById = this.categoryRepo.findById(categoryEntity.getId());
		if(findById.isPresent()) {
			CategoryEntity save = this.categoryRepo.save(categoryEntity);
			return new ResponseEntity<CategoryEntity>(save, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<CategoryEntity>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> deleteCategory(int id) {
		Optional<CategoryEntity> categoryEntity = this.categoryRepo.findById(id);
		if(categoryEntity.isPresent()) {
			this.categoryRepo.deleteById(id);
			return new ResponseEntity<CategoryEntity>(HttpStatus.OK);
		}else {
			return new ResponseEntity<CategoryEntity>(HttpStatus.NOT_FOUND);
		}
		
	}

}