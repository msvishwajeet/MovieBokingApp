package com.movieBooking.service;

import java.util.Iterator;
import com.movieBooking.model.Movie;
public interface MovieService {
	String releaseMovie(String name,String language);
	Movie getMovieDetails(String movieName);
	
	Iterator<Movie> allMovie();
}
