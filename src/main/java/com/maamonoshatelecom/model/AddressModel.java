package com.maamonoshatelecom.model;

public class AddressModel {
	private int id;
	private String street;
	private String city;
	private String state;
	private String country;
	private int zip_code;
	private int user_id;
	public AddressModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressModel(int id, String street, String city, String state, String country, int zip_code, int user_id) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip_code = zip_code;
		this.user_id = user_id;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip_code=" + zip_code + ", user_id=" + user_id + "]";
	}
	
	
	
}
