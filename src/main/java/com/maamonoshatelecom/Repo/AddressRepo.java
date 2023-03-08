package com.maamonoshatelecom.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maamonoshatelecom.Entity.AddressEntity;
import com.maamonoshatelecom.Entity.UserEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, Integer> {

	void deleteAllByuserEntity(UserEntity userEntity);
	
	List<AddressEntity> findAllByuserEntity(UserEntity userEntity);

}
