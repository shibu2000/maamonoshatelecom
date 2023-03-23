package com.maamonoshatelecom.Response;

import java.time.LocalDateTime;
import java.util.Map;

public class OrderResponse {

	private String id;
	
	//Implementing Map<ProductID, Count>
	private Map<Integer, Integer> productList;
	
	private int shipping_address_id;
	private int billing_address_id;
	private String status;
	private long totalAmount;
	
	private LocalDateTime orderDateTime;
	
	private LocalDateTime expectedDelivery;
	private String notes;
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderResponse(String id, Map<Integer, Integer> productList, int shipping_address_id, int billing_address_id,
			String status, long totalAmount, LocalDateTime orderDateTime, LocalDateTime expectedDelivery,
			String notes) {
		super();
		this.id = id;
		this.productList = productList;
		this.shipping_address_id = shipping_address_id;
		this.billing_address_id = billing_address_id;
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
	public Map<Integer, Integer> getProductList() {
		return productList;
	}
	public void setProductList(Map<Integer, Integer> productList) {
		this.productList = productList;
	}
	public int getShipping_address_id() {
		return shipping_address_id;
	}
	public void setShipping_address_id(int shipping_address_id) {
		this.shipping_address_id = shipping_address_id;
	}
	public int getBilling_address_id() {
		return billing_address_id;
	}
	public void setBilling_address_id(int billing_address_id) {
		this.billing_address_id = billing_address_id;
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
		return "OrderResponse [id=" + id + ", productList=" + productList + ", shipping_address_id="
				+ shipping_address_id + ", billing_address_id=" + billing_address_id + ", status=" + status
				+ ", totalAmount=" + totalAmount + ", orderDateTime=" + orderDateTime + ", expectedDelivery="
				+ expectedDelivery + ", notes=" + notes + "]";
	}
	
	
}
