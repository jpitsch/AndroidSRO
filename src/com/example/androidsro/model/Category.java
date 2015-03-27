package com.example.androidsro.model;

/**
 * type Category struct {
		CategoryId int
		Name       string
	}
 *
 */

public class Category {
	private int categoryId;
	private String name;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
