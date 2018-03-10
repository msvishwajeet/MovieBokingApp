package com.movieBooking.model;
import java.util.Map;

public class Theatre {
	private String theatreName;
	private Address address;
	private Map<Movie,TimeSlot> movieList;
	
	public Map<Movie, TimeSlot> getMovieList() {
		return movieList;
	}
	public void setMovieList(Map<Movie, TimeSlot> movieList) {
		this.movieList = movieList;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
