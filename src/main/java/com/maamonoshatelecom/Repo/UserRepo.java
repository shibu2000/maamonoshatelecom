package com.maamonoshatelecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maamonoshatelecom.maamonoshatelecomEntity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{

}
