package com.maamonoshatelecom.Response;

public class ProductResponse {

	int id;
	String productName;
	int productPrice;
	String productDesc;
	
	// Base64 String format of Image File container
	private String productImageFile;
	private String productImageName;

	

	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductResponse(int id, String productName, int productPrice, String productDesc, String productImageFile,
			String productImageName) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productImageFile = productImageFile;
		this.productImageName = productImageName;
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



	@Override
	public String toString() {
		return "ProductResponse [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productImageFile=" + productImageFile + ", productImageName="
				+ productImageName + "]";
	}
	
	
}
