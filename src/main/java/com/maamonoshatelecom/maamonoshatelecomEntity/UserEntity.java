package com.maamonoshatelecom.maamonoshatelecomEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	long mobile;
	String address;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(int id, long mobile, String address) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", mobile=" + mobile + ", address=" + address + "]";
	}

}
