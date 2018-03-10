package com.movieBooking.service;
import java.util.Iterator;
import com.movieBooking.model.Theatre;

public class AddressServiceImpl implements AddressService {
	TheatreService theatreService;
	public AddressServiceImpl(TheatreService theatreService) {
		this.theatreService=theatreService;
	}
	@Override
	public Iterator<Theatre> getTheatrelist() {
		Iterator<Theatre> li= theatreService.theatre();
		return li;
	}

}
