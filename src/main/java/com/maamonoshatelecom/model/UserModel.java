package com.maamonoshatelecom.model;

import java.util.HashSet;
import java.util.Set;

public class UserModel {

	private String firstName;
	private String lastName;
	private long mobile;
	private String email;
	private String password;
	
	private Set<Integer> roles = new HashSet<Integer>();
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String firstName, String lastName, long mobile, String email, String password,
			Set<Integer> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.roles = roles;
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

	public Set<Integer> getRoles() {
		return roles;
	}

	public void setRoles(Set<Integer> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserModel [firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile + ", email="
				+ email + ", password=" + password + ", roles=" + roles + "]";
	}
	
	
}
