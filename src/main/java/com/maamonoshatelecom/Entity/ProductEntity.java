package com.maamonoshatelecom.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String productName;
	int productPrice;
	String productDesc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryid")
	CategoryEntity categoryEntity;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(int id, String productName, int productPrice, String productDesc,
			CategoryEntity categoryEntity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
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

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", categoryEntity=" + categoryEntity + "]";
	}
	
	
	
}
