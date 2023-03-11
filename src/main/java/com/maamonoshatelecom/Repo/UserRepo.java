package com.maamonoshatelecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maamonoshatelecom.Entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String>{

}
