package com.maamonoshatelecom.Response;

import java.util.HashSet;
import java.util.Set;

public class UserResponse {

	private String id;
	private String firstName;
	private String lastName;
	private long mobile;
	private String email;
	private String password;
	
	private Set<String> role_name = new HashSet<>();

	public UserResponse(String id, String firstName, String lastName, long mobile, String email, String password,
			Set<String> role_name) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.role_name = role_name;
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole_name() {
		return role_name;
	}

	public void setRole_name(Set<String> role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", password=" + password + ", role_name=" + role_name + "]";
	}

	
}
