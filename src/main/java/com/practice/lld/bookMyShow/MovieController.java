package com.practice.lld.bookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
	
	Map<String, List<Movie>> cityMovieMap;
	List<Movie> allMovies;
	
	public MovieController(){
		this.cityMovieMap = new HashMap<>();
		this.allMovies = new ArrayList<>();
	}
	
	public void addMovie(String city, Movie movie) {
		List<Movie> movieList = new ArrayList<>();
		if (!cityMovieMap.containsKey(city)) {
			cityMovieMap.put(city, movieList);
		}
		else {
			movieList = cityMovieMap.get(city);
		}
		movieList.add(movie);
		
		if (!allMovies.contains(movie))
			allMovies.add(movie);
	}
	
	public void showAllMovies(){
		System.out.println("printing all movies");
		printMovies(this.allMovies);
	}
	
	public void showMoviesInCity(String city){
		if (cityMovieMap.containsKey(city)) {
			System.out.println("printing movies for city : " + city);
			printMovies(cityMovieMap.get(city));
		}
		else {
			System.out.println(" there is no movie for city : " + city);
		}		
	}

	private void printMovies(List<Movie> list) {
		for (Movie movie : list) {
			System.out.println(movie);
		}
	}
}
