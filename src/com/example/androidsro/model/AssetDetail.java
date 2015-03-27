package com.example.androidsro.model;

/**
 * type AssetDetails struct {
		AssetId  string
		Title    string
		Category string
		AppKey   string
	}
 *
 */

public class AssetDetail {
	private String assetId;
	private String title;
	private String categoryId;
	private String appKey;
	
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategory(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
}
