package com.maamonoshatelecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maamonoshatelecom.Entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{

}
