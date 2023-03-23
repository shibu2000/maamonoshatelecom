package com.maamonoshatelecom.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.maamonoshatelecom.customIDgenerator.CustomOrderIDGenerator;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_order_id_generator")
	@GenericGenerator(name = "custom_order_id_generator", strategy = "com.maamonoshatelecom.customIDgenerator.CustomOrderIDGenerator", parameters = {
			@Parameter(name = CustomOrderIDGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = CustomOrderIDGenerator.VALUE_PREFIX_PARAMETER, value = "ODR"),
			@Parameter(name = CustomOrderIDGenerator.NUMBER_FORMAT_PARAMETER, value = "%09d") })
	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	@ManyToMany
	@JoinTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<ProductEntity> products = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "shipping_address_id")
	private AddressEntity shippingAddress;

	@OneToOne
	@JoinColumn(name = "billing_address_id")
	private AddressEntity billingAddress;

	private String status;
	private long totalAmount;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime orderDateTime;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime expectedDelivery;

	private String notes;

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEntity(String id, UserEntity userEntity, List<ProductEntity> products, AddressEntity shippingAddress,
			AddressEntity billingAddress, String status, long totalAmount, LocalDateTime orderDateTime,
			LocalDateTime expectedDelivery, String notes) {
		super();
		this.id = id;
		this.userEntity = userEntity;
		this.products = products;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.status = status;
		this.totalAmount = totalAmount;
		this.orderDateTime = orderDateTime;
		this.expectedDelivery = expectedDelivery;
		this.notes = notes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public AddressEntity getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressEntity shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public AddressEntity getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressEntity billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public LocalDateTime getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(LocalDateTime expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", userEntity=" + userEntity + ", products=" + products + ", shippingAddress="
				+ shippingAddress + ", billingAddress=" + billingAddress + ", status=" + status + ", totalAmount="
				+ totalAmount + ", orderDateTime=" + orderDateTime + ", expectedDelivery=" + expectedDelivery
				+ ", notes=" + notes + "]";
	}

}
