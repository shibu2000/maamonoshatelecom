package com.maamonoshatelecom.service;

import java.util.List;

import com.maamonoshatelecom.Entity.UserEntity;

public interface UserService {
	int postUser(UserEntity userEntity);
	List<UserEntity> getUser();
	int putUser(UserEntity userEntity);
	int deleteUser(int id);

}