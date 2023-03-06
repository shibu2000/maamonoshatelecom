package com.maamonoshatelecom.Repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maamonoshatelecom.Entity.CategoryEntity;
import com.maamonoshatelecom.Entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{
	
	Optional<List<ProductEntity>> findBycategoryEntity(CategoryEntity categoryEntity);
}
