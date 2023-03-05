package com.maamonoshatelecom.model;

public class ProductModel {

	int id;
	String productName;
	int productPrice;
	String productDesc;
	int categoryId;
	String categoryname;
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(int id, String productName, int productPrice, String productDesc, int categoryId,
			String categoryname) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.categoryId = categoryId;
		this.categoryname = categoryname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", categoryId=" + categoryId + ", categoryname=" + categoryname
				+ "]";
	}
	
	
}
