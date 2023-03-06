package com.maamonoshatelecom.model;

public class ProductModel {

	String productName;
	int productPrice;
	String productDesc;
	
	// Base64 String format of Image File container
	private String productImageFile;
	private String productImageName;

	int categoryId;
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductModel(String productName, int productPrice, String productDesc, String productImageFile,
			String productImageName, int categoryId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productImageFile = productImageFile;
		this.productImageName = productImageName;
		this.categoryId = categoryId;
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

	public String getProductImageFile() {
		return productImageFile;
	}

	public void setProductImageFile(String productImageFile) {
		this.productImageFile = productImageFile;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ProductModel [productName=" + productName + ", productPrice=" + productPrice + ", productDesc="
				+ productDesc + ", productImageFile=" + productImageFile + ", productImageName=" + productImageName
				+ ", categoryId=" + categoryId + "]";
	}

	
	
}
