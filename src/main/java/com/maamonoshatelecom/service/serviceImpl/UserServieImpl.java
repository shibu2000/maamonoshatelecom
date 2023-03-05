package com.maamonoshatelecom.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.UserEntity;
import com.maamonoshatelecom.Repo.UserRepo;
import com.maamonoshatelecom.service.UserService;

@Service
public class UserServieImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public int postUser(UserEntity userEntity) {
		this.userRepo.save(userEntity);
		return 200;
	}

	@Override
	public List<UserEntity> getUser() {
		List<UserEntity> findAll = this.userRepo.findAll();
		return findAll;
	}

	@Override
	public int putUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		this.userRepo.deleteById(id);
		return 200;
	}

}
