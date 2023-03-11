package com.maamonoshatelecom.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.RolesEntity;
import com.maamonoshatelecom.Entity.UserEntity;
import com.maamonoshatelecom.Repo.RolesRepo;
import com.maamonoshatelecom.Repo.UserRepo;
import com.maamonoshatelecom.Response.UserResponse;
import com.maamonoshatelecom.model.UserModel;
import com.maamonoshatelecom.service.UserService;

@Service
public class UserServieImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RolesRepo rolesRepo;

	@Override
	public ResponseEntity<?> postUser(UserModel userModel) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userModel.getFirstName());
		userEntity.setLastName(userModel.getLastName());
		userEntity.setMobile(userModel.getMobile());
		userEntity.setEmail(userModel.getEmail());
		userEntity.setPassword(userModel.getPassword());

		Set<RolesEntity> rolesEntities = new HashSet<>();

		userModel.getRoles().forEach(role -> {
			Optional<RolesEntity> findById = this.rolesRepo.findById(role);
			if (findById.isPresent()) {
				rolesEntities.add(findById.get());
			}
		});

		userEntity.setRoles(rolesEntities);

		UserEntity save = this.userRepo.save(userEntity);

		return ResponseEntity.accepted().body(save);
	}

	@Override
	public ResponseEntity<?> getUser() {
		List<UserEntity> findAll = this.userRepo.findAll();
		List<UserResponse> userResponses = new ArrayList<>();
		
		findAll.forEach(user->{
			UserResponse userResponse = new UserResponse();
			
			userResponse.setId(user.getId());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setMobile(user.getMobile());
			userResponse.setEmail(user.getEmail());
			userResponse.setPassword(user.getPassword());
			Set<String> roles_name = new HashSet<>();
			
			user.getRoles().forEach(user_roles->{
				roles_name.add(user_roles.getRole_name());
			});
			
			userResponse.setRole_name(roles_name);
			
			userResponses.add(userResponse);
		});
		
		return ResponseEntity.ok(userResponses);
	}

	@Override
	public ResponseEntity<?> putUser(String id, UserModel userModel) {
		Optional<UserEntity> findById = this.userRepo.findById(id);
		
		if (findById.isPresent()) {
			UserEntity userEntity = new UserEntity();
			
			userEntity.setFirstName(userModel.getFirstName());
			userEntity.setLastName(userModel.getLastName());
			userEntity.setMobile(userModel.getMobile());
			userEntity.setEmail(userModel.getEmail());
			userEntity.setPassword(userModel.getPassword());

			Set<RolesEntity> rolesEntities = new HashSet<>();

			userModel.getRoles().forEach(role -> {
				Optional<RolesEntity> findById2 = this.rolesRepo.findById(role);
				if (findById2.isPresent()) {
					rolesEntities.add(findById2.get());
				}
			});
			userEntity.setRoles(rolesEntities);

			UserEntity save = this.userRepo.save(userEntity);
			if(save != null) {
				return ResponseEntity.accepted().body("Data Updated");
			}else {
				return ResponseEntity.internalServerError().body("Server Error");
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	@Override
	public ResponseEntity<?> deleteUser(String id) {
		try {
			this.userRepo.deleteById(id);
			return ResponseEntity.ok("Deleted");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<?> getUserByID(String id) {
		Optional<UserEntity> user = this.userRepo.findById(id);
		if(user.isPresent()) {
			
			UserResponse userResponse = new UserResponse();
			
			userResponse.setId(user.get().getId());
			userResponse.setFirstName(user.get().getFirstName());
			userResponse.setLastName(user.get().getLastName());
			userResponse.setMobile(user.get().getMobile());
			userResponse.setEmail(user.get().getEmail());
			userResponse.setPassword(user.get().getPassword());
			Set<String> roles_name = new HashSet<>();
			
			user.get().getRoles().forEach(user_roles->{
				roles_name.add(user_roles.getRole_name());
			});
			userResponse.setRole_name(roles_name);
			
			return ResponseEntity.ok().body(userResponse);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
		}
	}

}
