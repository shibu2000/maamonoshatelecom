package com.maamonoshatelecom.service;

import org.springframework.http.ResponseEntity;

import com.maamonoshatelecom.model.UserModel;

public interface UserService {
	ResponseEntity<?> postUser(UserModel userModel);
	ResponseEntity<?> getUser();
	ResponseEntity<?> getUserByID(String id);
	ResponseEntity<?> putUser(String id, UserModel userModel);
	ResponseEntity<?> deleteUser(String id);

}
