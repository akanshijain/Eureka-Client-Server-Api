package com.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingdataservice.models.Rating;
import com.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating>ratings= Arrays.asList(
				new Rating("778",4),
				new Rating("543",5)
				);
		UserRating userRating= new UserRating();
		userRating.setUserId(userId);
		userRating.setUserRating(ratings);
		 return userRating;
	}

}
