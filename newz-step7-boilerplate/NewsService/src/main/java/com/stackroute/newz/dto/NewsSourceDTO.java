package com.stackroute.newz.dto;


public class NewsSourceDTO {


	/*
	 * This class should have two fields
	 * (newsSourceId,userId). This class should also contain the getters and setters for the 
	 * fields. 
	 */
	
	private int newsSourceId;
	private String userId;

	public int getNewsSourceId() {
		return newsSourceId;
	}

	public void setNewsSourceId(int newsSourceId) {
		this.newsSourceId = newsSourceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
