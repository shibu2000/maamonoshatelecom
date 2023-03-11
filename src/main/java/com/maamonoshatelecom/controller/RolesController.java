package com.maamonoshatelecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maamonoshatelecom.service.RolesService;

@RestController
@RequestMapping(value = "/maamonoshatelecom/access-roles")
public class RolesController {

	@Autowired
	private RolesService rolesService;

	@PostMapping(value = "/add")
	ResponseEntity<?> addRoles(@RequestParam("name") String name) {
		return this.rolesService.addRoles(name);
	}

	@GetMapping(value = "/get")
	ResponseEntity<?> getRoles() {
		return this.rolesService.getRoles();
	}

	@DeleteMapping(value = "/remove")
	ResponseEntity<?> removeRoles(@RequestParam("id") int id) {
		return this.rolesService.removeRoles(id);
	}

	@PutMapping(value = "/update")
	ResponseEntity<?> putRoles(@RequestParam("id") int id, @RequestParam("name") String name) {
		return this.rolesService.putRoles(id, name);
	}

}
