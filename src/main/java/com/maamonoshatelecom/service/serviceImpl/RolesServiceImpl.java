package com.maamonoshatelecom.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.RolesEntity;
import com.maamonoshatelecom.Repo.RolesRepo;
import com.maamonoshatelecom.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService{
	
	@Autowired
	private RolesRepo rolesRepo;

	@Override
	public ResponseEntity<?> addRoles(String name) {
		RolesEntity rolesEntity = new RolesEntity();
		rolesEntity.setRole_name(name);
		RolesEntity save = this.rolesRepo.save(rolesEntity);
		return ResponseEntity.status(HttpStatus.OK).body(save.getRole_name());
	}

	@Override
	public ResponseEntity<?> removeRoles(int id) {
		try {
			this.rolesRepo.deleteById(id);
			return ResponseEntity.ok("Roles Removed");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<?> getRoles() {
		List<RolesEntity> findAll = this.rolesRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(findAll);
	}

	@Override
	public ResponseEntity<?> putRoles(int id, String name) {
		Optional<RolesEntity> findById = this.rolesRepo.findById(id);
		if(findById.isPresent()) {
			findById.get().setRole_name(name);
			RolesEntity save = this.rolesRepo.save(findById.get());
			return ResponseEntity.ok(save.getRole_name());
		}else {
			return ResponseEntity.badRequest().body("Not Found");
		}
		
	}

}
