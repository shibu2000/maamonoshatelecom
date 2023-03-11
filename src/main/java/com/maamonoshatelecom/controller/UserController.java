package com.maamonoshatelecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maamonoshatelecom.model.UserModel;
import com.maamonoshatelecom.service.UserService;

@RestController
@RequestMapping("/maamonoshatelecom/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	ResponseEntity<?> postUser(@RequestBody UserModel userModel) {
		return this.userService.postUser(userModel);
	}

	@GetMapping("/get")
	ResponseEntity<?> getUser() {
		return this.userService.getUser();
	}

	@DeleteMapping("/delete")
	ResponseEntity<?> deleteUser(@RequestParam("id") String id) {
		return this.userService.deleteUser(id);
	}

	@PutMapping(value = "/update")
	ResponseEntity<?> updateUser(@RequestParam("id") String id, @RequestBody UserModel userModel) {
		return this.updateUser(id, userModel);
	}
}
