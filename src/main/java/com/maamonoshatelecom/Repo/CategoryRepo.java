package com.maamonoshatelecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maamonoshatelecom.Entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer>{

}
