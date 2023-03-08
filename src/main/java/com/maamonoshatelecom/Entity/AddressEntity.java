package com.maamonoshatelecom.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserAddress")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private String state;
	private String country;

	@Column(length = 6)
	private int zip_code;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	UserEntity userEntity;


	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AddressEntity(int id, String street, String city, String state, String country, int zip_code,
			UserEntity userEntity) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip_code = zip_code;
		this.userEntity = userEntity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getZip_code() {
		return zip_code;
	}


	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip_code=" + zip_code + ", userEntity=" + userEntity + "]";
	}

	
	
}
