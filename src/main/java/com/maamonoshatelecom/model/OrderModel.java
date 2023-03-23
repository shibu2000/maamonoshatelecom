package com.maamonoshatelecom.model;

import java.util.List;
import java.util.Map;

class ProductCounts{
	private int product_id;
	private int count;
	public ProductCounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCounts(int product_id, int count) {
		super();
		this.product_id = product_id;
		this.count = count;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ProductCounts [product_id=" + product_id + ", count=" + count + "]";
	}
	
	
}


public class OrderModel {

	private String user_id;
	private Map<Integer, Integer> productList;
	private int shippingaddressID;
	private int billingAddressID;
	private String notes;
	
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderModel(String user_id, Map<Integer, Integer> productList, int shippingaddressID, int billingAddressID,
			String notes) {
		super();
		this.user_id = user_id;
		this.productList = productList;
		this.shippingaddressID = shippingaddressID;
		this.billingAddressID = billingAddressID;
		this.notes = notes;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Map<Integer, Integer> getProductList() {
		return productList;
	}

	public void setProductList(Map<Integer, Integer> productList) {
		this.productList = productList;
	}

	public int getShippingaddressID() {
		return shippingaddressID;
	}

	public void setShippingaddressID(int shippingaddressID) {
		this.shippingaddressID = shippingaddressID;
	}

	public int getBillingAddressID() {
		return billingAddressID;
	}

	public void setBillingAddressID(int billingAddressID) {
		this.billingAddressID = billingAddressID;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "OrderModel [user_id=" + user_id + ", productList=" + productList + ", shippingaddressID="
				+ shippingaddressID + ", billingAddressID=" + billingAddressID + ", notes=" + notes + "]";
	}

}
