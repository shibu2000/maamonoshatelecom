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

import com.maamonoshatelecom.model.AddressModel;
import com.maamonoshatelecom.service.AddressService;

@RestController
@RequestMapping("/maamonoshatelecom/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/save")
	ResponseEntity<?> saveAddress(@RequestBody AddressModel addressModel) {
		ResponseEntity<?> saveAddress = this.addressService.saveAddress(addressModel);
		return saveAddress;
	}
	
	@GetMapping("/get")
	ResponseEntity<?> getAddress(){
		ResponseEntity<?> address = this.addressService.getAddress();
		return address;
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<?> deleteAddress(@RequestParam("id") int id){
		ResponseEntity<?> deleteAddress = this.addressService.deleteAddress(id);
		return deleteAddress;
	}
	
	@PutMapping("/update")
	ResponseEntity<?> putAddress(@RequestParam("id") int id, @RequestBody AddressModel addressModel){
		ResponseEntity<?> putAddress = this.putAddress(id, addressModel);
		return putAddress;
	}
	
	@DeleteMapping("/delete-address-by-uid")
	ResponseEntity<?> deleteAddressByUserID(@RequestParam("userid") int userid){
		ResponseEntity<?> deleteAddressByUserID = this.addressService.deleteAddressByUserID(userid);
		return deleteAddressByUserID;
	}
	
	@GetMapping("/get-address-by-uid")
	ResponseEntity<?> getAddressByUser_ID(@RequestParam("userid") int userid){
		ResponseEntity<?> addressByUser_ID = this.addressService.getAddressByUser_ID(userid);
		return addressByUser_ID;
	}
}
