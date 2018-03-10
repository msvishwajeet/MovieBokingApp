package com.movieBooking.service;

import java.util.Iterator;
import java.util.Map;

import com.movieBooking.model.Address;
import com.movieBooking.model.Movie;
import com.movieBooking.model.Theatre;
import com.movieBooking.model.TimeSlot;

public interface TheatreService {
	String createThreatre(String thName,Address add);
	String addMovie(Movie m,String thName,TimeSlot t);
	Iterator<Theatre> theatre();
	Map<Movie,TimeSlot> listOfMovie(String thName);
}
