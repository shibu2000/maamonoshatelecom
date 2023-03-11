package com.maamonoshatelecom.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.maamonoshatelecom.customIDgenerator.CustomidGenerator;

@Entity
@Table(name = "users")
public class UserEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_id_generator")
	@GenericGenerator(name = "custom_id_generator", strategy = "com.maamonoshatelecom.customIDgenerator.CustomidGenerator", parameters = {
			@Parameter(name = CustomidGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = CustomidGenerator.VALUE_PREFIX_PARAMETER, value = "MMTU"),
			@Parameter(name = CustomidGenerator.NUMBER_FORMAT_PARAMETER, value = "%07d") })
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private long mobile;
	private String email;
	private String password;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	    )
	private Set<RolesEntity> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AddressEntity> addressEntities = new ArrayList<>();

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String id, String firstName, String lastName, long mobile, String email, String password,
			Set<RolesEntity> roles, List<AddressEntity> addressEntities) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.addressEntities = addressEntities;
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

	public Set<RolesEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolesEntity> roles) {
		this.roles = roles;
	}

	public List<AddressEntity> getAddressEntities() {
		return addressEntities;
	}

	public void setAddressEntities(List<AddressEntity> addressEntities) {
		this.addressEntities = addressEntities;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", password=" + password + ", roles=" + roles + ", addressEntities="
				+ addressEntities + "]";
	}
	
}
