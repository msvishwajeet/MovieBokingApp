package com.movieBooking.model;

import java.util.*;
public class Movie {
	private String name;
	private String language;
	private Date DoRelease;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getDoRelease() {
		return DoRelease;
	}
	public void setDoRelease(Date doRelease) {
		DoRelease = doRelease;
	}
	
	
}
