package com.moviecatalogservice.models;

import java.util.List;

public class UserRating {

	private List<Rating> userRating;
	public String getUserId() {
		return userId;
	}

	private String userId;

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

	public void setUserId(String userId) {
		this.userId=userId;
		
	}

	
	
}
