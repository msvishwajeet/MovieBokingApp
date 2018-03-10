package com.movieBooking.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.movieBooking.model.Address;
import com.movieBooking.model.Movie;
import com.movieBooking.model.Theatre;
import com.movieBooking.model.TimeSlot;

public class TheatreServiceImpl implements TheatreService {
	Map<String, Theatre> theatreMap=new HashMap<>();
	@Override
	public String createThreatre(String thName,Address add) {
		Theatre theatre=new Theatre();
		theatre.setTheatreName(thName);
		theatre.setMovieList(new HashMap<>());
		theatre.setAddress(add);
		theatreMap.put(thName, theatre);
		return "SuccessFully Added: "+ thName;
	}
	@Override
	public String addMovie(Movie m,String thName,TimeSlot t) {
		Theatre th = theatreMap.get(thName);
		th.getMovieList().put(m, t);
		return "Success";
	}
	@Override
	public Iterator<Theatre> theatre() {
		Iterator<Theatre> it= theatreMap.values().iterator();
		return it;
	}
	@Override
	public Map<Movie,TimeSlot> listOfMovie(String thName) {
		return theatreMap.get(thName).getMovieList();
	}
	
	
	
}
