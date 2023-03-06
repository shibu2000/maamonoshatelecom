package com.maamonoshatelecom.Entity;


import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private int productPrice;
	private String productDesc;
	
	@Lob
	private byte[] productImageFile; //Base64 to byte[]
	
	private String productImageName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryid")
	CategoryEntity categoryEntity;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(int id, String productName, int productPrice, String productDesc, byte[] productImageFile,
			String productImageName, CategoryEntity categoryEntity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productImageFile = productImageFile;
		this.productImageName = productImageName;
		this.categoryEntity = categoryEntity;
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

	public byte[] getProductImageFile() {
		return productImageFile;
	}

	public void setProductImageFile(byte[] productImageFile) {
		this.productImageFile = productImageFile;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productImageFile=" + Arrays.toString(productImageFile)
				+ ", productImageName=" + productImageName + ", categoryEntity=" + categoryEntity + "]";
	}

		
	
}
