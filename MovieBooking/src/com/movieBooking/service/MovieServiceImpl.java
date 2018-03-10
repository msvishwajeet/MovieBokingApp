package com.movieBooking.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.movieBooking.model.Movie;

public class MovieServiceImpl implements MovieService {
private final Map<String, Movie> movieMap=new HashMap<>();
	@Override
	public String releaseMovie(String name, String language) {
		Movie m=new Movie();
		m.setDoRelease(new Date());
		m.setName(name);
		m.setLanguage(language);
		movieMap.put(name, m);
		return "Succesfully Released:"+name;
	}

	@Override
	public Movie getMovieDetails(String movieName) {
		Movie m=movieMap.get(movieName);
		return m;
	}

	@Override
	public Iterator<Movie> allMovie() {
		return movieMap.values().iterator();
	}

}
