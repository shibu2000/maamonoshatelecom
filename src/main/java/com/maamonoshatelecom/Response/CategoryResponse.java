package com.maamonoshatelecom.Response;

public class CategoryResponse {
	private int id;
	private String categoryname;
	public CategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryResponse(int id, String categoryname) {
		super();
		this.id = id;
		this.categoryname = categoryname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Override
	public String toString() {
		return "CategoryResponse [id=" + id + ", categoryname=" + categoryname + "]";
	}
	
}
