package com.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.moviecatalogservice.models.CatalogItem;
import com.moviecatalogservice.models.Movie;
import com.moviecatalogservice.models.Rating;
import com.moviecatalogservice.models.UserRating;
import com.moviecatalogservice.service.MovieInfo;
import com.moviecatalogservice.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired()
	private RestTemplate restTemplate;

	@Autowired()
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired 
	private UserRatingInfo userRatingInfo;
    
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// RestTemplate restTemplate = new RestTemplate();

		// Movie
		// movie=restTemplate.getForObject("http://localhost:8081/movies/foo",Movie.class);

		// getall related moviesid
		
		UserRating ratings= userRatingInfo.getUserRating(userId);
		
		return ratings.getUserRating().stream().map(rating -> movieInfo.getCatalogItem(rating))
				.collect(Collectors.toList());
			  /// for each movie id call movie infoservice and get details 
			
			  // put them all together
			 
		
		
		/*
		 * List<Rating> ratings = Arrays.asList( new Rating("1234", 4), new
		 * Rating("4345", 3) );
		 */

		/*
		 * return ratings.stream().map(rating -> { /// for each movie id call movie info
		 * service and get details Movie movie =
		 * restTemplate.getForObject("http://localhost:8082/movies/" +
		 * rating.getMovieId(), Movie.class);
		 * 
		 * // put them all together
		 * 
		 * return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		 * }).collect(Collectors.toList());
		 */

		

		/*
		 * return Collections.singletonList( new CatalogItem("transformer", "Test", 4)
		 * );
		 */ 
		}
	
	
	
	
	/*
	public List<CatalogItem> getFallBackCatalog(@PathVariable("userId") String userId){
		return Arrays.asList(new CatalogItem("No movie","null",0));
	}*/
	
	
	/*
	 * Movie movie=webClientBuilder.build() //web client .get()
	 * //RequestHeadersUriSpace<capture of ?> .uri("http://localhost:8082/movies/" +
	 * rating.getMovieId()) .retrieve() .bodyToMono(Movie.class) //Mono<Movie>
	 * .block();
	 */
}
