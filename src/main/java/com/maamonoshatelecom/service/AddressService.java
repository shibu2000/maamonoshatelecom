package com.maamonoshatelecom.service;

import org.springframework.http.ResponseEntity;

import com.maamonoshatelecom.model.AddressModel;

public interface AddressService {
	ResponseEntity<?> saveAddress(AddressModel addressModel);
	ResponseEntity<?> getAddress();
	
	//Delete Address by address id
	ResponseEntity<?> deleteAddress(int id);
	
	ResponseEntity<?> putAddress(int id, AddressModel addressModel);
	
	ResponseEntity<?> deleteAddressByUserID(int userID);
	
	ResponseEntity<?> getAddressByUser_ID(int user_id);
}
