package com.maamonoshatelecom.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.AddressEntity;
import com.maamonoshatelecom.Entity.UserEntity;
import com.maamonoshatelecom.Repo.AddressRepo;
import com.maamonoshatelecom.Repo.UserRepo;
import com.maamonoshatelecom.Response.AddressResponse;
import com.maamonoshatelecom.model.AddressModel;
import com.maamonoshatelecom.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public ResponseEntity<?> saveAddress(AddressModel addressModel) {

		Optional<UserEntity> userEntity = this.userRepo.findById(addressModel.getUser_id());
		if (userEntity.isPresent()) {
			AddressEntity addressEntity = new AddressEntity();
			addressEntity.setCity(addressModel.getCity());
			addressEntity.setCountry(addressModel.getCountry());
			addressEntity.setState(addressModel.getState());
			addressEntity.setStreet(addressModel.getState());
			addressEntity.setZip_code(addressModel.getZip_code());
			addressEntity.setUserEntity(userEntity.get());

			AddressEntity save = this.addressRepo.save(addressEntity);
			if (save.getId() > 0) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.internalServerError().body("Server Error! Try again");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
		}

	}

	@Override
	public ResponseEntity<?> getAddress() {
		List<AddressEntity> findAll = this.addressRepo.findAll();
		
		List<AddressResponse> addressResponses = new ArrayList<>();
		
		findAll.forEach(address->{
			AddressResponse addressResponse = new AddressResponse();
			addressResponse.setId(address.getId());
			addressResponse.setCity(address.getCity());
			addressResponse.setCountry(address.getCountry());
			addressResponse.setStreet(address.getStreet());
			addressResponse.setState(address.getState());
			addressResponse.setZip_code(address.getZip_code());
			addressResponse.setUser_id(address.getUserEntity().getId());
			
			addressResponses.add(addressResponse);
		});
		
		return ResponseEntity.status(HttpStatus.OK).body(addressResponses);
	}

	@Override
	public ResponseEntity<?> deleteAddress(int id) {
		try {
			this.addressRepo.deleteById(id);
			return ResponseEntity.ok("Address Deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found in DATABASE");
		}
	}

	@Override
	public ResponseEntity<?> putAddress(int id, AddressModel addressModel) {
		Optional<UserEntity> user = this.userRepo.findById(addressModel.getUser_id());
		if (user.isPresent()) {
			Optional<AddressEntity> address = this.addressRepo.findById(id);
			if (address.isPresent()) {
				address.get().setCity(addressModel.getCity());
				address.get().setCountry(addressModel.getCountry());
				address.get().setState(addressModel.getState());
				address.get().setStreet(addressModel.getStreet());
				address.get().setZip_code(addressModel.getZip_code());
				address.get().setUserEntity(user.get());

				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not Exist");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Exist");
		}
	}

	@Override
	public ResponseEntity<?> deleteAddressByUserID(String userID) {
		try {
			this.addressRepo.deleteAllByuserEntity(this.userRepo.findById(userID).get());
			return ResponseEntity.ok("Delete Successfull");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
		}
	}

	@Override
	public ResponseEntity<?> getAddressByUser_ID(String user_id) {
		Optional<UserEntity> userEntity = this.userRepo.findById(user_id);

		List<AddressEntity> findAllByuserEntity = this.addressRepo.findAllByuserEntity(userEntity.get());

		if (findAllByuserEntity.size() > 0) {
			List<AddressModel> addressModels = new ArrayList<AddressModel>();
			findAllByuserEntity.forEach(address -> {
				AddressModel addressModel = new AddressModel();
				addressModel.setId(address.getId());
				addressModel.setCity(address.getCity());
				addressModel.setCountry(address.getCountry());
				addressModel.setState(address.getState());
				addressModel.setStreet(address.getStreet());
				addressModel.setZip_code(address.getZip_code());
//				addressModel.setUser_id(address.getUserEntity().getId());
				addressModels.add(addressModel);
			});

			return ResponseEntity.status(HttpStatus.OK).body(addressModels);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO DATA FOUND");
		}
	}

}
