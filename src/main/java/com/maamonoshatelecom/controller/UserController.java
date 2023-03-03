package com.maamonoshatelecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maamonoshatelecom.maamonoshatelecomEntity.UserEntity;
import com.maamonoshatelecom.service.UserService;

@RestController
@RequestMapping("/maamonoshatelecom")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("postuser")
	int postUser(@RequestBody UserEntity userEntity) {
		int findAll = this.userService.postUser(userEntity);
		return findAll;
	}

	@GetMapping("/getuser")
	List<UserEntity> getUser() {
		return this.userService.getUser();
	}
	
	@DeleteMapping("/deleteuser/{id}")
	int deleteUser(@PathVariable("id") int id)
	{
		return this.userService.deleteUser(id);
	}
}
