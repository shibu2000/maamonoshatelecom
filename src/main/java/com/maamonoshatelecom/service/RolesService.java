package com.maamonoshatelecom.service;

import org.springframework.http.ResponseEntity;

public interface RolesService {
	ResponseEntity<?> addRoles(String name);
	ResponseEntity<?> removeRoles(int id);
	ResponseEntity<?> getRoles();
	ResponseEntity<?> putRoles(int id, String name);
}
