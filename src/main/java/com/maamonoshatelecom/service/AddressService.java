package com.maamonoshatelecom.service;

import org.springframework.http.ResponseEntity;

import com.maamonoshatelecom.model.AddressModel;

public interface AddressService {
	ResponseEntity<?> saveAddress(AddressModel addressModel);
	ResponseEntity<?> getAddress();
	
	//Delete Address by address id
	ResponseEntity<?> deleteAddress(int id);
	
	ResponseEntity<?> putAddress(int id, AddressModel addressModel);
	
	ResponseEntity<?> deleteAddressByUserID(String userID);
	
	ResponseEntity<?> getAddressByUser_ID(String user_id);
}
